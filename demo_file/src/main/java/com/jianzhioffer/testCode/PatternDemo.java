package com.jianzhioffer.testCode;

import java.util.regex.Pattern;

/**
 * 正则表达式的练习
 */
public class PatternDemo {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 匹配一个数字
     */
    public static void test1(){
        String str = "223d";
        str.trim();
        boolean flag = Pattern.matches("[0-9]+",str);
        System.out.println(flag);
        int i = 1;
        while(i++ < 2){
            System.out.println("++");
        }
    }
}
