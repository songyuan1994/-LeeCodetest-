package com.demo.interviewCode.charpter1;

public class Student extends Person{
    private static String NAME="222";

    public Student(String name) {
        super(name);
    }

/*    @Override
    public void speak() {
        System.out.println("Stu speak");
    }*/

    public Student test(){
        return new Student("22");
    }
}
