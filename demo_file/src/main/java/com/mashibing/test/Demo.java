package com.mashibing.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String genome = "CGCGGCGCGCGCGTC";
        String coden = genome.substring(3,6);
        System.out.println(coden);
        String code = new String("GGC") ;
        String code2 = new String("GGC");
        String code3 = code;
        String code4 = "GGC";
        String code5 = "GGC";
/*        System.out.println(code==coden);
        System.out.println(code==code2);
        System.out.println(code==code3);
        System.out.println(code==code4);
        System.out.println(code5==code4);
        System.out.println("equal :"+code.equals(coden));*/

        char[] value = new char[2];
        StringDemo stringDemo = new StringDemo(value);
        stringDemo.value = new char[3];
        StringDemo stringDemo2 = new StringDemo(value);
        System.out.println(stringDemo==stringDemo2);

        List<String> list = new ArrayList<>();

        List<Integer> list1 = Arrays.asList(1,2,3,4);
        Object[] array = list1.toArray();




        ArrayList<String> arrayList = new ArrayList<>(list);
        arrayList.add("22");
    }
}
