package com.example.demo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class CreateQRCode {
	/** 
     * 生成二维码(QRCode)图片 
     * @param content 二维码图片的内容
     * @param imgPath 生成二维码图片完整的路径
     * @param ccbpath  二维码图片中间的logo路径
     */  
    public static int createQRCode(String content,String imgPath,String ccbPath) {  
        try {  
//            Qrcode qrcode=new Qrcode();
//            qrcode.setQrcodeErrorCorrect('M');
//            qrcode.setQrcodeEncodeMode('B');
//            qrcode.setQrcodeVersion(15);
            
            BufferedImage bufImg = new BufferedImage(235, 275, BufferedImage.TYPE_INT_RGB);  
            Graphics2D g2 = bufImg.createGraphics();  
            g2.setBackground(Color.WHITE);  
            g2.clearRect(0, 0, 235, 275);  
            g2.setColor(Color.BLACK);   
            byte[] contentbytes=content.getBytes("utf-8");
         //   boolean[][] codeout= qrcode.calQrcode(contentbytes);
//            for (int i = 0; i <codeout.length; i++) {
//                for (int j = 0; j < codeout.length; j++) {
//                    if (codeout[j][i]) g2.fillRect(j*3+2,i*3+2,3,3);
//                }
//            }   
            Image img = ImageIO.read(new File(ccbPath));//实例化一个Image对象。
            g2.drawImage(img, 87, 87, null);
            g2.dispose();  
            bufImg.flush();  
            // 生成二维码QRCode图片  
            File imgFile = new File(imgPath);  
            ImageIO.write(bufImg, "png", imgFile); 
            // 下部加载文字说明
            pressText("航景智慧安防", imgPath, imgPath, 1, Color.BLACK, 20,  235,  275) ;
            // 压缩二维码尺寸
            zipWidthHeightImageFile(new File(imgPath),new File(imgPath),136,159); 
        } catch (Exception e) {  
            e.printStackTrace();  
            return -100;
        }  
        return 0;
    } 
    /**
     * 二维码添加底部文字
     * @param pressText
     * @param newImg
     * @param targetImg
     * @param fontStyle
     * @param color
     * @param fontSize
     * @param width
     * @param height
     */
    public static void pressText(String pressText, String newImg, String targetImg, 
    		int fontStyle, Color color, int fontSize, int width, int height) {   
    			int start = width-(fontSize * pressText.length()/2);
	     int startX = (width-(fontSize*pressText.length()))/2;
	     int startY = height-(height-width)/2;        
	     try {
	         File file = new File(targetImg);
	         Image src = ImageIO.read(file);
	         int imageW = src.getWidth(null);
	         int imageH = src.getHeight(null);
	         BufferedImage image = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
	         Graphics2D g2 = image.createGraphics();
	         g2.drawImage(src, 0, 0, imageW, imageH, null);
	         g2.setColor(color);
	         g2.setFont(new Font("微软雅黑", fontStyle, fontSize));
	         g2.drawString(pressText, startX, startY);
	         g2.dispose();
	         FileOutputStream out = new FileOutputStream(newImg);
	         ImageIO.write(image, "png", out);
	         JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	         encoder.encode(image);
	         out.close();
	     } catch (Exception e) {
	        System.out.println(e);
	     }
    }
    /**
     *  压缩二维码图片
     * @param oldFile
     * @param newFile
     * @param width
     * @param height
     * @return
     */
    public static void zipWidthHeightImageFile(File oldFile,File newFile, int width, int height) {      
        try {    
            /** 对服务器上的临时文件进行处理 */    
            Image srcFile = ImageIO.read(oldFile);     
            String srcImgPath = newFile.getAbsoluteFile().toString();  
            String subfix = "png";  
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".")+1,srcImgPath.length());  
  
            BufferedImage buffImg = null;   
            if(subfix.equals("png")){  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);  
            }else{  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            }  
            Graphics2D graphics = buffImg.createGraphics();  
            graphics.setBackground(new Color(255,255,255));  
            graphics.setColor(new Color(255,255,255));  
            graphics.fillRect(0, 0, width, height);  
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);    
  
            ImageIO.write(buffImg, subfix, new File(srcImgPath));    
        } catch (FileNotFoundException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }   
    }  
}