package com.demo.interviewCode.charpter1.demo3;

/**
 * @author songyuan
 */
public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static class Dog extends Pet{

        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet{
        public Cat() {
            super("cat");
        }
    }
}
