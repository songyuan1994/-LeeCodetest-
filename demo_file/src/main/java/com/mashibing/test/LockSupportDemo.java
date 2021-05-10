package com.mashibing.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Thin'k'pa'd
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
            for(int i=0;i<10;i++){
                System.out.println(i);
                if(i == 5) {
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        TimeUnit.SECONDS.sleep(8);
        System.out.println("Main thread sleep 8");
        LockSupport.unpark(t);
    }
}
