package com.example.demo;

import groovy.transform.ToString;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.everhomes.util.DateHelper;
import com.everhomes.util.StringHelper;
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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.fonts.otf.TableHeader;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;

public class Test {

	public static void main(String args[]){		
		String content ="sy 2! 你好啊！！";
		String url="E:/test/";
		generatePdfFile(url,content);
		
//		List<String> arr = new ArrayList<String>();
//		arr.add("1");
//		arr.add("2");
//	    java.util.Iterator<String> at = arr.iterator();
//	    while(at.hasNext()){
//	    	String a = at.next()+"5";
//	    }
//		arr.stream().forEach(e ->System.out.println(e));
		
		
		
	}
//	
//	
//	public static void test(){
//		String aa = "asdasdasd";
//		Setts.setAppKey(aa);
//	}
	
	
	  public static void generatePdfFile(String pdf_url,String content){
	        Rectangle rectPageSize = new Rectangle(PageSize.A2);//A4纸张  
//	        rectPageSize.setBackgroundColor(BaseColor.BLACK);// 背景色
//	        rectPageSize.setBorder(1220);// 边框
//	        rectPageSize.setBorderColor(BaseColor.BLUE);
//	        rectPageSize.setBorderWidth(244.2f);

	        
	        Document document = new Document(rectPageSize, 40, 40, 40, 40);//上、下、左、右间距
	        String month="20181206";
	        String name="打印凭证"+month+".pdf";
	        try {
	            //创建一个PdfWriter实例    
	            //将文件输出流指向一个文件    
//	       	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		     PdfWriter.getInstance(document,baos);
	        	PdfWriter.getInstance(document,new FileOutputStream(pdf_url+name));  
	            
	         // 中文字体(现在高版本的不支持中文包)
	    		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	    		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);// 中文、12、正常

	    		Font titleChinese = new Font(bfChinese, 14, Font.BOLD);// 中文、12、正常
	    		
	    		Font fontBaseChinese = new Font(bfChinese, 12, Font.NORMAL);// 中文、12、正常

	    		Font titleBaseChinese = new Font(bfChinese, 14, Font.BOLD);// 中文、12、正常
	            
	            int colNumber = 11;
	            PdfPTable datatable = new PdfPTable(colNumber);
	            
	            PdfPTable datatableTitle = new PdfPTable(6);
	            //打开文档。    
	            document.open();
//	            Paragraph info = new Paragraph();
//	            info.add(new Chunk("创建时间", getChineseFont()));
//	            info.setAlignment(Element.ALIGN_JUSTIFIED);
//	            info.setLeading(20f);
//	    		info.add(new Chunk("chinese"));
//	    		info.add(Chunk.NEWLINE); // 好用的
//	    		info.add(new Phrase("Japan "));
//	    		info.add(new Phrase("japanese"));
//	    		//info.setSpacingAfter(10f);// 设置段落下空白
//	    		document.add(info);
	            
	            Paragraph info = new Paragraph();
	            info.add(new Paragraph("#商户平台账务汇总电子账单", titleChinese));
	            info.add(new Paragraph("#客户名称：XXXX公司", titleChinese));
	            info.add(new Paragraph("起始日期：[]    终止日期: []", titleChinese));
	            info.add(new Paragraph("#-------------------------------------------------------------财务汇总列表---------------------------------------------------", titleChinese));
	          
	            int[] cellsWidthTitle = { 1, 1, 1, 1, 1,1 };
	            datatableTitle.setWidths(cellsWidthTitle);
	            datatableTitle.setWidthPercentage(50); //宽度百分比
	            datatableTitle.setHorizontalAlignment(Element.ALIGN_LEFT); //对齐方式
	            datatableTitle.getDefaultCell().setPadding(2);// 单元格的间隔
	            datatableTitle.getDefaultCell().setBorderWidth(0);// 边框宽度
	            datatableTitle.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
	            datatableTitle.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	    		//添加标题
	            datatableTitle.addCell(new Paragraph("类型", titleChinese));
	            datatableTitle.addCell(new Paragraph("收入笔数", titleChinese));
	            datatableTitle.addCell(new Paragraph("收入金额", titleChinese));
	            datatableTitle.addCell(new Paragraph("支出笔数", titleChinese));
	            datatableTitle.addCell(new Paragraph("支出金额(-元)", titleChinese));
	            datatableTitle.addCell(new Paragraph("总金额(元)", titleChinese));

	    		//添加内容
	            
	            
	            datatableTitle.addCell(new Paragraph("支付", fontChinese));
	            datatableTitle.addCell(new Paragraph("2", fontChinese));
	            datatableTitle.addCell(new Paragraph("3.56", fontChinese));
	            datatableTitle.addCell(new Paragraph("3", fontChinese));
	            datatableTitle.addCell(new Paragraph("-22.60", fontChinese));
	            datatableTitle.addCell(new Paragraph("33.62", fontChinese));
	            
	            datatableTitle.addCell(new Paragraph("提现", fontChinese));
	            datatableTitle.addCell(new Paragraph("12", fontChinese));
	            datatableTitle.addCell(new Paragraph("3.52", fontChinese));
	            datatableTitle.addCell(new Paragraph("23", fontChinese));
	            datatableTitle.addCell(new Paragraph("-32.60", fontChinese));
	            datatableTitle.addCell(new Paragraph("35.21", fontChinese));
	            
	            document.add(info);
	            document.add(datatableTitle);
	            Paragraph info2 = new Paragraph();
	            info2.add(new Paragraph("#-------------------------------------------------------------财务汇总列表结束----------------------------------------------", titleChinese));
	            info2.add(new Paragraph("导出时间： []",titleChinese));
	            info2.add(new Paragraph("#-------------------------------------------------------------财务明细列表---------------------------------------------------", titleChinese));
	            Phrase tPhrase = new Phrase();
	            tPhrase.add(Chunk.NEWLINE);
	            info2.add(tPhrase);
	            document.add(info2);
	            
	            
	    		// 定义表格的宽度
	    		int[] cellsWidth = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	    		datatable.setWidths(cellsWidth);// 单元格宽度
	    		// datatable.setTotalWidth(300f);//表格的总宽度
	    		//datatable.setWidthPercentage(100);// 表格的宽度百分比
	     
	    		datatable.getDefaultCell().setPadding(2);// 单元格的间隔
	    		datatable.getDefaultCell().setBorderWidth(1);// 边框宽度
	    		// 设置表格的底色
	    		datatable.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
	    		datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	     
	    		// PdfPTable[PdfPCell[Paragraph]]
	    		// 添加表头元素
//	    		for (int i = 0; i < colNumber; i++) {
//	    			datatable.addCell(new Paragraph("1: "+i, fontChinese));
//	    		}
	    		datatable.addCell(new Paragraph("创建时间", titleChinese));
	    		datatable.addCell(new Paragraph("交易号", titleChinese));
	    		datatable.addCell(new Paragraph("订单号", titleChinese));
	    		datatable.addCell(new Paragraph("业务类型", titleChinese));
	    		datatable.addCell(new Paragraph("订单来源", titleChinese));
	    		datatable.addCell(new Paragraph("订单金额(元)", titleChinese));
	    		datatable.addCell(new Paragraph("入账金额(元)", titleChinese));
	    		datatable.addCell(new Paragraph("支付方式", titleChinese));
	    		datatable.addCell(new Paragraph("手续费(元)", titleChinese));
	    		datatable.addCell(new Paragraph("交易状态", titleChinese));
	    		datatable.addCell(new Paragraph("订单说明", titleChinese));
	    		
	    		// 添加表格的内容   		
	    		datatable.addCell(new Paragraph(new Timestamp(DateHelper.currentGMTTime().getTime()).toString(), fontChinese));
	    		datatable.addCell(new Paragraph("2013065", fontChinese));
	    		datatable.addCell(new Paragraph("2013065", fontChinese));
	    		datatable.addCell(new Paragraph("充值", fontChinese));
	    		datatable.addCell(new Paragraph("停车", fontChinese));
	    		datatable.addCell(new Paragraph("1.01", fontChinese));
	    		datatable.addCell(new Paragraph("-1.01", fontChinese));
	    		datatable.addCell(new Paragraph("网管支付", fontChinese));
	    		datatable.addCell(new Paragraph("1.00", fontChinese));
	    		datatable.addCell(new Paragraph("支付完成", fontChinese));
	    		datatable.addCell(new Paragraph("这是订单说明。测试长度，123456789123456789", fontChinese));
	    		
	    		for (int i = 0; i < 100; i++) {
	    		Timestamp tt = new Timestamp(1543993540000l);
	    		String aa=null;
	    		datatable.addCell(new Paragraph(tt.toLocaleString()));
	    		datatable.addCell(new Paragraph(aa==null? "":String.valueOf(aa), fontChinese));
	    		datatable.addCell(new Paragraph("2013065", fontChinese));
	    		datatable.addCell(new Paragraph("充值", fontChinese));
	    		datatable.addCell(new Paragraph("停车", fontChinese));
	    		Long amount =25l;
	    		BigDecimal bi = transAmount(amount);
	    		datatable.addCell(new Paragraph(bi.toString(), fontChinese));
	    		datatable.addCell(new Paragraph("-1.01", fontChinese));
	    		datatable.addCell(new Paragraph("网管支付", fontChinese));
	    		datatable.addCell(new Paragraph("1.00", fontChinese));
	    		datatable.addCell(new Paragraph("支付完成", fontChinese));
	    		datatable.addCell(new Paragraph("这是订单说明。测试长度，123456789123456789", fontChinese));
	    		}
	    		
//	    		for (int i = 1; i < colNumber; i++) {
//	    			datatable.addCell(new Paragraph("", fontChinese));
//	    		}
	     
	    		// 空白表格
//	    		for (int i = 0; i < colNumber; i++) {
//	    			PdfPCell cell = new PdfPCell(new Paragraph(""));
//	    			cell.setFixedHeight(10);// 单元格高度
//	    			datatable.addCell(cell);
//	    		}
	    		datatable.setSpacingAfter(40f);// 设置表格下面空白行

	    		
	    		document.add(datatable);
	    		
//	    		 byte[] pdfBytes = baos.toByteArray();
//	             System.out.println("The bytes are"+StringHelper.toJsonString(pdfBytes));
	    		
//	            document.add(new Paragraph("asd"));
//	            document.add(new Paragraph("中文测试111： ", getChineseFont()));
//	            //在文档中增加一个段落
//	            //解决中文乱码    
//	            document.add(new Paragraph(content,new Font(BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED),14,Font.NORMAL)));    

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
