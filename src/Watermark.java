import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Watermark {
	/*
	 * watermarki do zdjec
	 * wczytaj zdjecie
	 * dodaj napis
	 * dodaj obrazek
	 * zapisz w folderze output
	 * 
	 */
	//public static 
	
	
	

	
	public static void main(String[] args) {
		
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("1.jpg"));
		} catch (IOException e) {
			System.out.println("blad tu w IO.read");
		}
				
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage waterMark = null;
		try {
			 waterMark = ImageIO.read(new File("pobrane.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(waterMark.getType());
		BufferedImage imageWithMark = new BufferedImage(w, h, img.getType());
		Graphics g = imageWithMark.getGraphics();
		g.drawImage(img, 0, 0, null);
		g.drawImage(waterMark, (int) 0.1*h, (int) 0.1*w, null);
		g.setColor(Color.BLACK);
		
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		g.drawString("Kosmita w kosmosie!", (int) (0.8*w), (int) (0.8*h));
		File f = new File("Sukcessss.jpg");
		try {
			ImageIO.write(imageWithMark, "JPG", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
         
	       
	}

}
