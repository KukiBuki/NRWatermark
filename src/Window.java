import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSlider;

public class Window extends JFrame {

	//zmienne i stale
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtWwwnominaplFbcomnomina;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_1;
	BufferedImage waterMark = ImageIO.read(new File("nomina.png"));
	final DefaultListModel<File> model = new DefaultListModel<File>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Window() throws IOException {
	
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("BKANT.TTF")));
		} catch (FontFormatException e2) {
			e2.printStackTrace();
		}
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 550, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		//punkt w aplikacji do wyswietlania komunikatow
		final JLabel shouter = new JLabel("");
		shouter.setBounds(10, 92, 539, 20);
		panel.add(shouter);

		//wgrywanie watermarka
		JButton btnWgrajWatermark = new JButton("Wgraj Watermark");
		btnWgrajWatermark.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				FileFilter filter = new FileNameExtensionFilter("Image files","jpg", "gif", "png", "tiff");
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(filter);
				fc.setAcceptAllFileFilterUsed(false);
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						waterMark = ImageIO.read(fc.getSelectedFile());
						shouter.setText("za³adowano Watermark");
					} catch (IOException e) {
						e.printStackTrace();
						shouter.setText("nie uda³o siê za³adowaæ");
					}
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(5, 139, 550, 367);
		contentPane.add(scrollPane_1);
		final JList<File> list = new JList<File>(model);
		scrollPane_1.setViewportView(list);
		list.setDropMode(DropMode.ON);
		
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setRowHeaderView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
	
		//dodawanie plikow do edycji
		JButton btnNewButton = new JButton("Add Files");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				FileFilter filter = new FileNameExtensionFilter("Image files","jpg", "gif", "png", "tiff");
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(filter);
				fc.setAcceptAllFileFilterUsed(false);
				fc.setMultiSelectionEnabled(true);
				int returnVal = fc.showOpenDialog(null);
				File[] files=fc.getSelectedFiles();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					for (int i = 0; i<fc.getSelectedFiles().length; i++) {
						int pos = list.getModel().getSize();
						model.add(pos, files[i]);
					}
				}
			}
		});
		
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Files");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int maxSel = list.getMaxSelectionIndex();
			int minSel = list.getMinSelectionIndex();
			for (int i=maxSel; i>=minSel; i--) {
				model.remove(i);
				}
			}
		});
		panel_1.add(btnNewButton_1);
		btnWgrajWatermark.setBounds(10, 4, 170, 25);
		panel.add(btnWgrajWatermark);
		
		txtWwwnominaplFbcomnomina = new JTextField();
		txtWwwnominaplFbcomnomina.setText("www.nomina.pl - fb.com/NominaRosae");
		txtWwwnominaplFbcomnomina.setBounds(272, 17, 227, 20);
		panel.add(txtWwwnominaplFbcomnomina);
		txtWwwnominaplFbcomnomina.setColumns(10);
		
		JRadioButton rB = new JRadioButton("1");
		buttonGroup.add(rB);
		rB.setActionCommand("1");
		rB.setBounds(186, 4, 21, 23);
		panel.add(rB);
		rB.setSelected(true);
		
		JRadioButton rB1 = new JRadioButton("2");
		buttonGroup.add(rB1);
		rB1.setActionCommand("2");
		rB1.setBounds(209, 4, 21, 23);
		panel.add(rB1);
		
		JRadioButton rB2 = new JRadioButton("3");
		buttonGroup.add(rB2);
		rB2.setActionCommand("3");
		rB2.setBounds(186, 28, 21, 23);
		panel.add(rB2);
		
		JRadioButton rB3 = new JRadioButton("4");
		buttonGroup.add(rB3);
		rB3.setActionCommand("4");
		rB3.setBounds(209, 28, 21, 23);
		panel.add(rB3);
		
		JRadioButton rB4 = new JRadioButton("1");
		buttonGroup_1.add(rB4);
		rB4.setActionCommand("1");
		rB4.setBounds(505, 4, 21, 23);
		panel.add(rB4);
		
		JRadioButton rB5 = new JRadioButton("2");
		buttonGroup_1.add(rB5);
		rB5.setActionCommand("2");
		rB5.setBounds(528, 4, 21, 23);
		panel.add(rB5);
		
		JRadioButton rB7 = new JRadioButton("4");
		buttonGroup_1.add(rB7);
		rB7.setActionCommand("4");
		rB7.setBounds(528, 28, 21, 23);
		panel.add(rB7);
		rB7.setSelected(true);
		
		JRadioButton rB6 = new JRadioButton("3");
		buttonGroup_1.add(rB6);
		rB6.setActionCommand("3");
		rB6.setBounds(505, 28, 21, 23);
		panel.add(rB6);
		
		JLabel lblNewLabel_1 = new JLabel("tekst:");
		lblNewLabel_1.setBounds(236, 20, 35, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("30");
		textField_1.setBounds(431, 48, 68, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCzcionka = new JLabel("rozmiar");
		lblCzcionka.setToolTipText("tylko cyfry");
		lblCzcionka.setBounds(374, 48, 52, 14);
		panel.add(lblCzcionka);
		
		JLabel lblCzcionki = new JLabel("czcionki:");
		lblCzcionki.setToolTipText("tylko cyfry");
		lblCzcionki.setBounds(374, 62, 52, 14);
		panel.add(lblCzcionki);
		
		final JSlider opacity = new JSlider();
		opacity.setSnapToTicks(true);
		opacity.setPaintTicks(true);
		opacity.setMinorTickSpacing(10);
		opacity.setBounds(10, 40, 170, 28);
		panel.add(opacity);
		opacity.setMaximum(100);
		opacity.setMinimum(0);
		opacity.setValue(100);
		
		JLabel lblPrzezroczysto = new JLabel("0%          widoczno\u015B\u0107        100%");
		lblPrzezroczysto.setToolTipText("");
		lblPrzezroczysto.setBounds(10, 62, 170, 20);
		panel.add(lblPrzezroczysto);
		//pattern do wylapywania zle wpisanej czcionki
		final Pattern pt = Pattern.compile("\\d+");
		
		JButton btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {
		
				//³apanie errorów
				if (buttonGroup.getSelection().getActionCommand() == buttonGroup_1.getSelection().getActionCommand()){
					
					shouter.setText("b³¹d: ta sama pozycja Watermarku i tekstu");
					
				}else if(textField_1.getText().isEmpty()){
					
					shouter.setText("ustaw rozmiar czcionki");
					
				}else if(!pt.matcher(textField_1.getText()).matches()){
					
					shouter.setText("rozmiar czcionki tylko cyframi");
					
				}else {
					//g³ówne zadanie - tu sklada obrazki	
					//tu stale dla wszystkich
					int listLength = model.size();
					float alpha = (float) (opacity.getValue()/100.0);
					int type = AlphaComposite.SRC_OVER; 
					AlphaComposite composite = 
					  AlphaComposite.getInstance(type, alpha);
					double widthScale = waterMark.getWidth()/waterMark.getHeight();
					//iteracja po wszystkich obrazkach i konkret
					for (int i = 0; i<listLength; i++) {
						list.setSelectedIndex(i);
						BufferedImage image=null;
						try {
							image = ImageIO.read(list.getSelectedValue());
						} catch (IOException e1) {
							
							shouter.setText("nie mogê odczytaæ za³adowanego obrazu nr " + i+1);
						}
						int w = image.getWidth();
						int h = image.getHeight();
						
						int newWMHeigth = w/15;
						int newWMWidth= (int) (newWMHeigth*widthScale);
						
						BufferedImage imageWithMark = new BufferedImage(w, h, image.getType());
						Graphics2D g = imageWithMark.createGraphics();
						
						g.drawImage(image, null, 0, 0);
						
						g.setColor(Color.white);
						g.setFont(new Font("Book Antiqua", Font.PLAIN, (int) Integer.parseInt(textField_1.getText())));
						//umieszczenie napisu
						if (buttonGroup_1.getSelection().getActionCommand() == "1") {
							g.drawString(txtWwwnominaplFbcomnomina.getText(), 50, 50+Integer.parseInt(textField_1.getText()));
						} else if (buttonGroup_1.getSelection().getActionCommand() == "2") {
							g.drawString(txtWwwnominaplFbcomnomina.getText(), w-g.getFontMetrics().stringWidth(txtWwwnominaplFbcomnomina.getText())-50, 50+Integer.parseInt(textField_1.getText()));											
						} else if (buttonGroup_1.getSelection().getActionCommand() == "3") {
							g.drawString(txtWwwnominaplFbcomnomina.getText(), 50, h-50);
						} else if (buttonGroup_1.getSelection().getActionCommand() == "4") {
							g.drawString(txtWwwnominaplFbcomnomina.getText(), w-g.getFontMetrics().stringWidth(txtWwwnominaplFbcomnomina.getText())-50, h-50);
						}
						
						g.setComposite(composite);
						//umieszczenie watermarka
						if (buttonGroup.getSelection().getActionCommand() == "1") {
							g.drawImage(waterMark, 50, 50, newWMWidth, newWMHeigth,  null);
						} else if (buttonGroup.getSelection().getActionCommand() == "2") {
							g.drawImage(waterMark, w-50-waterMark.getWidth(), 50, null);
						} else if (buttonGroup.getSelection().getActionCommand() == "3") {
							g.drawImage(waterMark, 50, h-50-waterMark.getHeight(), null);
						} else if (buttonGroup.getSelection().getActionCommand() == "4") {
							g.drawImage(waterMark, w-50-waterMark.getWidth(), h-50-waterMark.getHeight(), null);	
						}
						
						File dir = new File(list.getSelectedValue().getParentFile() + "\\output");
						dir.mkdirs();
						File f = new File(list.getSelectedValue().getParentFile() + "\\output\\" + list.getSelectedValue().getName());
						try {
						ImageIO.write(imageWithMark, "JPG", f);
						} catch (IOException e) {
				
							shouter.setText("Nie mogê zapisaæ pliku");
						}
						
						g.dispose();						
					}
				}
			}
		});
		btnGo.setBounds(5, 517, 555, 23);
		contentPane.add(btnGo);
	}
}
