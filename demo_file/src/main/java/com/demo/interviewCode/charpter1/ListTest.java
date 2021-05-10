package com.demo.interviewCode.charpter1;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public <T extends Person> void temp1(List<T> list){}

    public static void temp2(List<Student> list){}

    public static void temp3(Person person){}

    public static String ACCESS_URL = "http://suplatform.sugram.chat/broadcast/";

    public static void main(String[] args) {



        String url="http://suad.sugram.chat/broadcast/sgfuli_577073405929455616.html";
        url = StringUtils.replace(url ,ACCESS_URL ,"");
        if(!url.contains(ACCESS_URL)){
            System.out.println("222");
        }
        System.out.println(url);
    }
}
