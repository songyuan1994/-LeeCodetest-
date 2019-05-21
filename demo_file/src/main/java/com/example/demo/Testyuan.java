package com.example.demo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Testyuan {
	
	public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = output.createGraphics();
		g2.setComposite(AlphaComposite.Src);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.WHITE);
		g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
		g2.setComposite(AlphaComposite.SrcAtop);
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
		return output;

	}
	
	
	public static void main(String args[]) throws IOException{
//		BufferedImage image = ImageIO.read(new File("E:/test/20181227141739.jpg"));
//		BufferedImage rounded = makeRoundedCorner(image, 40);
//		ImageIO.write(rounded, "png", new File("E:/test/testRel.png"));

	     	String pressText ="点位名称（自定义）成飒飒擦伤擦伤";
	     	String nextText ="";
	     	String beginText = "";
	     	if(pressText.length()>15){
	     		nextText = pressText.substring(15);
	     		beginText = pressText.substring(0, 15);
	     	}
   	     	String aa2 ="aaaaassss";
	     	System.out.println(beginText);
	     	System.out.println(nextText);
	}
}
