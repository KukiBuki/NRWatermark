import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
	public static ImageIO addWatermark(ImageIO img) {
		
		
		
		
		ImageIO imgW = null;
		return imgW;
	}
	
	
	
	
	
	public static void main(String[] args) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("ith.jpg"));
		} catch (IOException e) {
		}
		
		System.out.println(img);
		
		 
         
	       
	}

}
