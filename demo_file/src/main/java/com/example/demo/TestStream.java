package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;

import com.everhomes.util.StringHelper;
import com.example.demo.entity.Teacher;
import com.itextpdf.text.log.SysoCounter;

public class TestStream {
	public static void main(String args[]){
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Teacher t1= new Teacher();
		t1.setAgeId("22");
		t1.setType(1);
		
		Teacher t2= new Teacher();
		t2.setAgeId("33");
		t2.setType(2);
		
		Teacher t3= new Teacher();
		t3.setAgeId("44");
		t3.setType(1);
		teacherList.add(t1);
		teacherList.add(t2);
		teacherList.add(t3);
		
		List<Teacher> newTeacherList = new ArrayList<Teacher>();
		newTeacherList = teacherList.stream().filter(t -> t.getType()==1).collect(Collectors.toList());
		teacherList.stream().filter(t -> t.getType()==1).map(Teacher::getAgeId).forEach(a ->System.out.println(StringHelper.toJsonString(a)));;
		
		teacherList.stream().filter(t -> t.getType()==1).map(Teacher::getAgeId).forEach(a ->System.out.println(StringHelper.toJsonString(a)));;
		
		
		System.out.println("The old are"+StringHelper.toJsonString(teacherList));
		
		//newTeacherList.stream().forEach(a ->System.out.println(StringHelper.toJsonString(a)));
		
		
		
	}
}	
