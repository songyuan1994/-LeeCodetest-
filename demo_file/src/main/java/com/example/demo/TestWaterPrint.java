package com.example.demo;
import java.awt.Color;  
import java.io.BufferedOutputStream;  
import java.io.ByteArrayOutputStream;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;  
import java.util.Calendar;  

import com.alipay.api.domain.PosFixedDishGroupModel;
import com.everhomes.util.DateHelper;
import com.everhomes.util.StringHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class TestWaterPrint {  
    public static void main(String[] args) throws DocumentException,  
            IOException {  
        // 要输出的pdf文件  
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("E:/test/2aa.pdf")));  
//        Calendar cal = Calendar.getInstance();  
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
//        // 将pdf文件先加水印然后输出  
//        setWatermark(bos, "E:/test/打印凭证20181219.pdf", format.format(cal.getTime())  
//                + "  下载使用人：" + "测试user", 16); 
    	
    	test();
    }  
  
    public static void setWatermark(BufferedOutputStream bos, String input,  
            String waterMarkName, int permission,PdfWriter writer) throws DocumentException,  
            IOException {  
        PdfReader reader = new PdfReader(new FileInputStream(input));  
        PdfStamper stamper = new PdfStamper(reader, bos);  
        int total = reader.getNumberOfPages()+1 ;  
        PdfContentByte content ;  
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);  
        PdfGState gs = new PdfGState();  
        for (int i = 1; i < total; i++) {  
            content = stamper.getOverContent(i);// 在内容上方加水印  
           // content = stamper.getUnderContent(i);//在内容下方加水印  
            gs.setFillOpacity(0.6f);  
            content.setGState(gs);  
            content.beginText();  
            content.setColorFill(BaseColor.LIGHT_GRAY);
           // content.setGrayFill(Color.LIGHT_GRAY);  
            content.setFontAndSize(base, 50);  
            content.setTextMatrix(70, 200);  
            content.showTextAligned(Element.ALIGN_CENTER, "公司内部文件，请注意保密！", 700,1200, 55);  
            content.setFontAndSize(base, 8);  
//            content.showTextAligned(Element.ALIGN_CENTER, "下载时间："  
//                    + waterMarkName + "", 300, 10, 0);  
            content.endText();  
  
        }  
        stamper.close();  
    }
    
    
    public static void test(){
    	Rectangle rectPageSize = new Rectangle(PageSize.A2);//A4纸张  
    	  Document document = new Document(rectPageSize, 40, 40, 40, 40);//上、下、左、右间距
	        String month="20181206";
	        String name="打印凭证"+month+".pdf";
	        try {
	            //将文件输出流指向一个文件    
		       	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
			    	PdfWriter.getInstance(document,baos);
		        	//PdfWriter.getInstance(document,new FileOutputStream(pdf_url+name));  
		            
		         // 中文字体(现在高版本的不支持中文包)
		    		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		    		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);// 中文、12、正常

		    		Font titleChinese = new Font(bfChinese, 14, Font.BOLD);// 中文、12、正常	        	
		    		 PdfPTable datatable = new PdfPTable(11);
			            
			            PdfPTable datatableTitle = new PdfPTable(6);
			            //打开文档。    
			            document.open();
			            Paragraph info2 = new Paragraph();
			            info2.add(new Paragraph("#-------------------------------------------------------------财务汇总列表结束----------------------------------------------", titleChinese));
			            info2.add(new Paragraph("导出时间： []",titleChinese));
			            info2.add(new Paragraph("#-------------------------------------------------------------财务明细列表---------------------------------------------------", titleChinese));
			            Phrase tPhrase = new Phrase();
			            tPhrase.add(Chunk.NEWLINE);
			            info2.add(tPhrase);
			            document.add(info2);
			            
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
//			    		for (int i = 0; i < colNumber; i++) {
//			    			datatable.addCell(new Paragraph("1: "+i, fontChinese));
//			    		}
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
			    		BigDecimal bi = new BigDecimal(0);
			    		datatable.addCell(new Paragraph(bi.toString(), fontChinese));
			    		datatable.addCell(new Paragraph("-1.01", fontChinese));
			    		datatable.addCell(new Paragraph("网管支付", fontChinese));
			    		datatable.addCell(new Paragraph("1.00", fontChinese));
			    		datatable.addCell(new Paragraph("支付完成", fontChinese));
			    		datatable.addCell(new Paragraph("这是订单说明。测试长度，123456789123456789", fontChinese));
			    		}
			    		datatable.setSpacingAfter(40f);// 设置表格下面空白行
			    		
			    		document.add(datatable);
			            
			            byte[] pdfBytes = baos.toByteArray();
			            
			            PdfReader reader = new PdfReader(pdfBytes);  //?reader值不能为空？
			            PdfStamper stamper = new PdfStamper(reader, baos);  
			             
			             int total = reader.getNumberOfPages()+1 ;  
			             PdfContentByte content;  
			             BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);  
			             PdfGState gs = new PdfGState();  
			             for (int i = 1; i < total; i++) {  
			                 content = stamper.getOverContent(i);// 在内容上方加水印  
			                 gs.setFillOpacity(0.6f);  
			                 content.setGState(gs);  
			                 content.beginText();  
			                 content.setColorFill(BaseColor.LIGHT_GRAY);
			                 content.setFontAndSize(base, 50);  
			                 content.setTextMatrix(70, 200);  
			                 content.showTextAligned(Element.ALIGN_CENTER, "公司内部文件，请注意保密！", 700,1000, 55);  
			                 content.setFontAndSize(base, 8);  
			                 content.endText();  
			             } 
			             stamper.close();
			            
			             System.out.println("The bytes 22 are"+StringHelper.toJsonString(pdfBytes));
	        } catch (DocumentException de) {    
	            System.err.println(de.getMessage());    
	        } catch (IOException ioe) {    
	            System.err.println(ioe.getMessage());    
	        }    
	        //关闭文档。    
	        document.close();
    }
}