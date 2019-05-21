package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcle {
	public static void main(String args[]) throws Exception{
		String file ="E:/yinhang/222.xlsx";
		File files = new File(file);
		if (null == files || !files.exists()) {
			System.out.println("Null");
		}
		InputStream in = new FileInputStream(files);
		Workbook wb = WorkbookFactory.create(in);
		   //获得excel文件对象
		Sheet s = wb.getSheetAt(0);	//获取文件的指定工作表
		s.getPhysicalNumberOfRows();
		BankNameCode bk = new BankNameCode();
		for(int i=1;i<s.getPhysicalNumberOfRows();i++){
			Row row = s.getRow(i);
			List<String> rowList = new ArrayList<String>();
			/** 循环Excel的列 */
			for (int c = 0; c < row.getLastCellNum(); c++) {
				Cell cell = row.getCell(c);
				System.out.println(cell.toString());
			}
			System.out.println("第二行");
		}
		
		
	}
}
