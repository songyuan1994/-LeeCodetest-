package com.example.demo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import com.everhomes.util.DateHelper;
import com.everhomes.util.StringHelper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class Test2 {
	/**
	 * 二维码生成器的类
	  */
	public static class QRImageUtil {
	      //私有不可更改的变量：生成二维码图片的颜色
	    private static final int BLACK = 0xFF000000;
	    private static final int WHITE = 0xFFFFFFFF;
	    //空的构造方法
	    public QRImageUtil() {
	    }
	    /**
	     * 静态方法
	     * BufferedImage是Image的一个子类，BufferedImage生成的图片在内存里有一个图像缓冲区，利用这个缓冲区我们可以很方便的操作这个图片，
	     * 通常用来做图片修改操作如大小变换、图片变灰、设置图片透明或不透明等。
	     * @param matrix 编码形式
	     * @return
	     * @throws IOException 
	     */
	    public static BufferedImage toBufferedImage(BitMatrix matrix,int imageWdith ,int imageHeight,int fontSize,int titleSize,String titleText,String pressText) throws IOException
	    {
	    	
	    		InputStream imagein2_file = new FileInputStream( "E:/test/QRcode_recommend.png");
	    		InputStream imagein_bg_file = new FileInputStream( "E:/test/QRcode_bg.png");
	    		
	    		BufferedImage image_buttom = ImageIO.read(imagein2_file);  //底部图片
	    		BufferedImage image_bg = ImageIO.read(imagein_bg_file);  //背景图片
	            //图片的宽度和高度
	            int width = matrix.getWidth();
	            int height = matrix.getHeight();
	   	     	//二维码图片坐标
	   	     	int qrCodeStartWidth = (imageWdith-width)/2;
	   	     	int qrCodeStartHeight = (imageHeight-height)*2/3;
	   	     	
	   	     	
	   	     	Color light_blue = new Color(137, 207, 240);  //设置背景蓝色
	   	     	
		     	String secondLineText ="";
		     	String firstLineText = "";
		     	
		     	//设置点位名称坐标
		     	int startX = 0;
		     	int startY = imageHeight-(imageHeight-imageWdith)-250/2;
		     	if(pressText.length()>15){
		     		secondLineText = pressText.substring(15);
		     		firstLineText = pressText.substring(0, 15);
		     		startX = (imageWdith-(fontSize*firstLineText.length()))/2;
		     	}else{
		     		startX = (imageWdith-(fontSize*pressText.length()))/2;
		     	}
	   	     	
	            int startTitleX = (imageWdith-(titleSize*titleText.length()))/2;
	   	     	int startTitleY = (imageHeight-height)/2;
	   	     	
	            //BufferedImage.TYPE_INT_RGB将图片变为什么颜色
	            BufferedImage image_qr = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		        BufferedImage image_rel = new BufferedImage(imageWdith,imageHeight+image_buttom.getHeight(),BufferedImage.TYPE_INT_RGB);
//	            for(int x = qrCodeStartWidth;x < width+qrCodeStartWidth+150;x++)
//	            {
//	                    for(int y = qrCodeStartHeight-100;y < height+qrCodeStartHeight-100;y++)
//	                    {
//		                    image_qr.setRGB(x, y, matrix.get(x-qrCodeStartWidth, y-qrCodeStartHeight+100) ? BLACK : WHITE);
//	                    }
//	            }
	            for(int x = 0;x < width;x++)
	            {
	                    for(int y = 0;y < height;y++)
	                    {
		                    image_qr.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
	                    }
	            }
	            BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	            Graphics2D g = image_bg.createGraphics();
	            Graphics2D g3 = output.createGraphics();
	    		//生成圆角
	            g3.setComposite(AlphaComposite.Src);
	    		g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    		g3.setColor(Color.WHITE);
	    		g3.fill(new RoundRectangle2D.Float(0, 0, width, height, 70, 70));
	    		g3.setComposite(AlphaComposite.SrcAtop);
	    		g3.drawImage(image_qr, 0, 0, null);
	            //添加背景图
	    		g.drawImage(output, qrCodeStartWidth, qrCodeStartHeight, width, height, null);
//	            g.setColor(light_blue);
//	            g.fillRect(0, 0, imageWdith, qrCodeStartHeight);
//	            g.fillRect(0, 0, (imageWdith-width)/2, imageHeight-(imageHeight-height)/2);
//	            g.fillRect(imageWdith-(imageWdith-width)/2, 0, imageWdith, imageHeight-(imageHeight-height)/2);
//	            g.fillRect(0, imageHeight-(imageHeight-height)/2, imageWdith, imageHeight);
	            //添加标题
	            g.setColor(Color.WHITE);
		        g.setFont(new Font("宋体", 1, titleSize));
		        g.drawString(titleText, startTitleX, startTitleY);
	            g.setColor(Color.BLACK);
		        g.setFont(new Font("微软雅黑", 0, fontSize));
	            if(StringHelper.hasContent(firstLineText)){
	            	g.drawString(firstLineText, startX, startY);
	            	g.drawString(secondLineText, startX, startY+fontSize+20);
	            }else{
	            	g.drawString(pressText, startX, startY);
	            }
	            g.drawImage(image_buttom, 0, imageHeight,
	            		imageWdith, image_buttom.getHeight(), null);
		        //拼接底部图片
	            Graphics2D g2 = image_rel.createGraphics();
	            g2.drawImage(image_bg, 0, 0,
	            		imageWdith, imageHeight, null);
	            g2.drawImage(image_buttom, 0, imageHeight,
	            		imageWdith, image_buttom.getHeight(), null);
	            g.dispose();
	            g2.dispose();
	            g3.dispose();
	            image_buttom.flush();
	            image_qr.flush();
	            image_bg.flush();
	            image_rel.flush();
	            


	            return image_rel;
	    }
	    /**
	     * 静态方法 用于生成图片
	     * @param matrix 编码形式
	     * @param format 图片类型
	     * @param file 文件（图片路径，图片名称）
	     * @throws IOException
	     */
	    public static void writeToFile(BitMatrix matrix,String format,File file,int imageWdith ,int imageHeight,int fontSize,int titleSize,String titleText,String pressText) throws IOException
	    {
	            BufferedImage image = toBufferedImage(matrix,imageWdith,imageHeight,fontSize,titleSize,titleText,pressText);
	            //ImageIO.write(image, format, file);
	            if(!ImageIO.write(image, format, file))
	            {
	                    throw new IOException("Could not write an image of format " + format + " to " + file);
	            }
	    }
	    /**
	     * 输出
	     * @param matrix
	     * @param format
	     * @param stream
	     * @throws IOException
	     */
	    public void writeToStream(BitMatrix matrix,String format,OutputStream stream,int imageWdith ,int imageHeight,int fontSize,int titleSize,String titleText,String pressText) throws IOException
	    {
	            BufferedImage image = toBufferedImage(matrix,imageWdith,imageHeight,fontSize,titleSize, titleText, pressText);
	            if(!ImageIO.write(image, format, stream))
	            {
	                    throw new IOException("Could not write an image of format " + format);
	            }
	    }   

	    public static void test() throws Exception{
	    	Long id = 10l;
	         //二维码中保存的信息
	        //String content = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb41bf4f38a9ee046&redirect_uri=http%3a%2f%2f10.1.140.29%3a8180%2ftestWechatAouth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";//"http://10.1.140.29:8180/testReadQc?id="+id;
	        String content = "http://10.1.140.29:8080/pay/user/readQrCode?qrcodeId=12";
	        //生成的二维码保存的路径
	        String aa = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCijTch3CLi18f/fxZCeFSJnwn5mL1YNMAs4qxoq+GnLYdcMO6vPRim6zq8sIVOWIVaRtNtag2QJR4djob9ofCwZMJ08mtRwaoWmc4vwksQcau6n9JGP3Pyf3nAKQngT3zD/UfS4YPI5yzi2ZPRXlVN1+67GZ4lYx/UCGNvnXzovYwCeG43OrU1k7k/gx+mLYSbIzklZZ0fH5bxcFYS6QcGzZa0x7LD7BFwSYyWlazcQ7wpqVCpDwq0mRKJMlIFRzxqiJwYFyZADg6IBZphq06WylTs+MT6O22oQ0bbRpXoGccSnJRHDe7e6daVsJPjhjY5VRTHW4JdEh0w/M/3Gb21AgMBAAECggEAaCKxvDZr/wkf7lV7bC/scJH7cPRh8N0ydE7vBst+b3xiaDRM5OTuIxk1cuZfMFbTb4dKMaEseTjeNy802c3iBQ836HXZPPIlxf7YsY32St2Xl6KFsk06OZNi6zEfS52An4pmdfnVVGKNRfL/mLSnT4xTO3fo8ai0HkEVes7Y07x5aGwntsmziUO2/kTkoGZvzpLFdhVNlCSIR/56Pfk2xRjryVo+uqswgWiIWpPsoppZgCvaXX1ItG7Id7X2eam8CeZybRlwptnuwy4F/dtVdNcZ/62SGUKvQUeAI8fh66mgZQupzI4g90XuGXp9u9R60l+fU4Um/cmdWvxhpiwi4QKBgQDygF8XjAZ8ygpK2hchdYY0gpQz4e0X53qSjqriwxjbDVsgsRCSPRH+84wrMOAKEw2xZk8Vf/eStnqMrHfmrLKc2hS7AScCOcwzYQono+d1XpPrZS+qbHOwt9rvFD7WEDldL3zzKSykzysr1auTgkbROKCanWhWqdJtBDzCc5V8rQKBgQCrmZCC/1C3vYupTBy3CAtdNh8bvuC4nziBQ4eUGdYIb8/hVV2as4KDI7R/ezUSERNJQJjqVMHlesWWK3e01AidwvwtzEBqKtaTCyYZPO/VVy8bxwrzef1FLILlApuk3v68WDStt/+uhrMtXD5xpkywZGBxx2/nBO6iZackFs6eKQKBgQCBaVxV1pYHtlJzy5sYcf1ivGSWo3TBkvhoidZMGU2EaMY+1f8/63NVGWeuDPEirzRZfX2qvZXDJ7qSo9+ArJzM89yoR18n4uxEZv7iVKfKjORndKJRUnsSzar6d1VpK1NRlWwa39hBQ4WIaQidOaLNOGkM2f+6b/opz18VblVSKQKBgQCXl8n6b+K271P586tKZmjjp3RD5pRPhRk92JJlW42hVmWnAur2R678ewZxuD5h/4OyKsbr/IRuXc8/opbVwJr8A80UCGS/Zai5rheyJAsbxTFwsJ4UCaic+32HIo6tT/JqIOIotWvCmmyfneXsMKV/Dq3E1hMdW1YVUQge8acGQQKBgGdTEWPcEIjXEVGMl0FxM2DYuxKdRgWrG/gab6DUTs+EQAQSr4HtF0cB5yJtqKLzeuW08O6OcHOcJGc4zAsvamoal68te3PdQUVcqJRSHo7yREPkjHGn6136GgxGxVFaYRfhJMFfW7s9fFXYbxAVXm7dOrlkQfpObmphojDm2fkB";
	        System.err.println("aa is "+aa);
	        String path = "E:/test/";
	        MultiFormatWriter multiFormatWrite = new MultiFormatWriter();
	        Map hints = new HashMap();
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	        // 按照指定的宽度，高度和附加参数对字符串进行编码
	        //生成二维码
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        BitMatrix bitMatrix = multiFormatWrite.encode(content, BarcodeFormat.QR_CODE, 660, 800, hints);
	        File file1 = new File(path,sdf.format(new Date())+"sytest"+".jpg");
            int imageWdith = 1260; //图片大小
            int imageHeight = 1408;
            int fontSize = 35;  //字体大小
            int titleFontSize = 105; //标题大小
   	     	String titleText ="扫码买单";
   	     	String pressText ="点位啊实打实名称（自定义）2"; //点位名称
	        // 写入文件
	        writeToFile(bitMatrix, "jpg", file1,imageWdith,imageHeight,fontSize,titleFontSize,titleText,pressText);
	        
	        System.out.println("二维码图片生成成功！");
	    }
	
	public static void main(String[] args) throws Exception {
		Date date1 = DateHelper.currentGMTTime();
				test();
		Date date2 = DateHelper.currentGMTTime();
		System.out.println(date2.getTime()-date1.getTime());
		}
	}
}
