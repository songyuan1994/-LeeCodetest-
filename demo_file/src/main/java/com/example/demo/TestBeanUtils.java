package com.example.demo;

import org.springframework.beans.BeanUtils;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;

public class TestBeanUtils {
	
	//测试BeanUtils的对象赋值方法
	public static void main(String args[]){
		Student s = new Student();
		s.setAge_id("ages");
		s.setId(1l);
		s.setName("stu");
		
		Teacher t = new Teacher();
		 BeanUtils.copyProperties(s, t);
		 System.out.println(String.valueOf(t.getAgeId()).toString());
		 System.out.println(String.valueOf(t.getId()).toString());
		
	}
}
