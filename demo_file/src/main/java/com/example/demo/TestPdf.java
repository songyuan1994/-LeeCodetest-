package com.example.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

import com.everhomes.util.DateHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPdf {


	public static void main(String args[]){		
		String content ="sy 2! 你好啊！！";
		String url="E:/test/";
		generatePdfFile(url,content);

	
		
	}
	
	  public static void generatePdfFile(String pdf_url,String content){
	        Rectangle rectPageSize = new Rectangle(PageSize.A2);//A4纸张  
	        
	        Document document = new Document(rectPageSize, 40, 40, 40, 40);//上、下、左、右间距
	        String month="20181206";
	        String name="打印凭证222"+month+".pdf";
	        
	        String orderId = "1234567588";
	        String bizOrderNum = "BIZ4654654";
	        
	        try {
	            //创建一个PdfWriter实例    
	        	PdfWriter.getInstance(document,new FileOutputStream(pdf_url+name));  
	            
	         // 中文字体(现在高版本的不支持中文包)
	    		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	    		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);// 中文、12、正常

	    		Font titleChinese = new Font(bfChinese, 16, Font.BOLD);// 中文、12、正常
	            
	            //打开文档。    
	            document.open();
	            
	            Paragraph info = new Paragraph();
	            info.add(new Paragraph("交易详情", titleChinese));
				Phrase tPhraseTitle = new Phrase();
				tPhraseTitle.add(Chunk.NEWLINE);
				info.add(tPhraseTitle);
	            
				
				
				PdfPTable datatableTitle = new PdfPTable(3);
	            int[] cellsWidthTitle = { 1, 1, 1};
	            datatableTitle.setWidths(cellsWidthTitle);
	            datatableTitle.setWidthPercentage(100); //宽度百分比
	            datatableTitle.setHorizontalAlignment(Element.ALIGN_LEFT); //对齐方式
	            datatableTitle.getDefaultCell().setPadding(10);// 单元格的间隔
	            datatableTitle.getDefaultCell().setBorderWidth(0);// 边框宽度
	            datatableTitle.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
	            datatableTitle.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	    		//添加标题
	            datatableTitle.addCell(new Paragraph("交易流水号："+orderId, fontChinese));
	            datatableTitle.addCell(new Paragraph("业务订单号: "+bizOrderNum, fontChinese));
	            datatableTitle.addCell(new Paragraph("", titleChinese));
	           
	            datatableTitle.addCell(new Paragraph("业务类型", fontChinese));
	            datatableTitle.addCell(new Paragraph("交易来源", fontChinese));
	            datatableTitle.addCell(new Paragraph("交易说明", fontChinese));
	            
	            datatableTitle.addCell(new Paragraph("支付", fontChinese));
	            datatableTitle.addCell(new Paragraph("物业缴费", fontChinese));
	            datatableTitle.addCell(new Paragraph("中天产业园10月份账单", fontChinese));
	            
	            
	            datatableTitle.addCell(new Paragraph("交易金额", fontChinese));
	            datatableTitle.addCell(new Paragraph("支付方式", fontChinese));
	            datatableTitle.addCell(new Paragraph("手续费", fontChinese));
	            
	            datatableTitle.addCell(new Paragraph("123.00", fontChinese));
	            datatableTitle.addCell(new Paragraph("支付宝", fontChinese));
	            datatableTitle.addCell(new Paragraph("0.2", fontChinese));
	            
	            
	            datatableTitle.addCell(new Paragraph("付款方名称（付款方ID）", fontChinese));
	            datatableTitle.addCell(new Paragraph("收款方名称（收款方ID）", fontChinese));
	            datatableTitle.addCell(new Paragraph("", fontChinese));
	            
	            datatableTitle.addCell(new Paragraph("永佳天成（123）", fontChinese));
	            datatableTitle.addCell(new Paragraph("永佳天成收款（456）", fontChinese));
	            datatableTitle.addCell(new Paragraph("", fontChinese));
	            
	            
	            Paragraph info2 = new Paragraph();
	            info2.add(new Paragraph("订单状态", titleChinese));
	            info2.add(new Paragraph("待支付",fontChinese));
				Phrase tPhraseTitle2 = new Phrase();
				tPhraseTitle2.add(Chunk.NEWLINE);
				info.add(tPhraseTitle2);
				info2.add(new Paragraph("创建交易单",titleChinese));
				info2.add(new Paragraph("2017-10-01 12:00",fontChinese));
				
	            document.add(info);
	            document.add(datatableTitle);
	            document.add(info2);
	          
	    		
	        } catch (DocumentException de) {    
	            System.err.println(de.getMessage());    
	        } catch (IOException ioe) {    
	            System.err.println(ioe.getMessage());    
	        }    
	        //关闭文档。    
	        document.close();
	    }
	  
	  public static BigDecimal transAmount(Long amount){
      	BigDecimal orderAmount = new BigDecimal(amount).divide(new BigDecimal("100"));
      	orderAmount = orderAmount.setScale(2,RoundingMode.DOWN);
		return orderAmount;
	  }
	  
	  
	  public static Font getChineseFont() {
			BaseFont bfChinese;
			Font fontChinese = null;
			try {
				bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
				// fontChinese = new Font(bfChinese, 12, Font.NORMAL);
				fontChinese = new Font(bfChinese, 12, Font.BOLD, BaseColor.BLACK);
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fontChinese;
	 
		}


}
