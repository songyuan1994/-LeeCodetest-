package testLeetCode;

import org.apache.commons.lang.IllegalClassException;

public class TestThree {
	public static Long maxNum = 2147483647l;
	public static int minNum = -2147483648;
	
	
	public static void main(String args[]){
		Long num =9646324351l;
		if(num>maxNum){
			System.out.println("out");
		}
		System.out.println(reverse(num.intValue()));
	}
	
	public static int reverse(int x){
        if(x>maxNum || x<minNum){
            throw new IllegalArgumentException("Index out 32bits");
        }
		StringBuffer sb = new StringBuffer(String.valueOf(x));
		if(x<0){
			sb.replace(0, 1, "");
		}
		System.out.println(sb);
		return Integer.valueOf(sb.reverse().toString());
		
		//throw new IllegalArgumentException("Index out 32bits");
	}
}
