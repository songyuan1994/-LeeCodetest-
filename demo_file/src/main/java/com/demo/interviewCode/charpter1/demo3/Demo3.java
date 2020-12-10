package com.demo.interviewCode.charpter1.demo3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author songyuan
 */
public class Demo3 {
    private Queue<Pet> queue = new LinkedList<>();

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        demo3.add(new Pet.Dog());
        demo3.add(new Pet.Cat());
        demo3.add(new Pet.Dog());
        demo3.add(new Pet.Cat());
        demo3.pollDog();
        demo3.pollAll();

    }

    private void add(Pet pet){
        queue.add(pet);
    }

    private void pollAll(){
        while (queue.size()>0){
            System.out.println(queue.poll().getType());
        }
    }

    private void pollDog(){
        Queue<Pet> newQueue = new LinkedList<>();
        while (queue.size()>0){
            Pet val = queue.poll();
            if("dog".equals(val.getType())){
                System.out.println("poll dog");
            }
            if("cat".equals(val.getType())){
                newQueue.add(val);
            }
        }
        queue = newQueue;
    }

}
