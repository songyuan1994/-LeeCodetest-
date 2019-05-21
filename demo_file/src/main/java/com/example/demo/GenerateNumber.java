package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateNumber {
	public static void main(String args[]){
		Long id=10l;
		String couponNumber ="";
		couponNumber = createNumber(id,couponNumber);
		System.out.println("The number is {}" + couponNumber);
	}
	
	
		 public static String createNumber(Long id,String number){
	         SimpleDateFormat df = new SimpleDateFormat("yyMMdd");//设置日期格式
	         String createTimeStr = df.format(new Date());
	
	         if (id.toString().length() <= 5) {
	        	 number = number + createTimeStr + "0";
	             Long couponNumberD = (long) (Math.random() * 900 + 100);
	             number = number + couponNumberD.toString();
	         } else {
	        	 number = number + createTimeStr + "1";
	         }
	         number = number + id.toString();
	         return number;
	 }
}
