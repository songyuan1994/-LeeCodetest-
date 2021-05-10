package com.mashibing.test;

import java.sql.Timestamp;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLacthDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(100);
        for(int i=0;i<100;i++){
            Thread thread = new Thread(() -> {
                System.out.println("thread begin");
                try {
                    TimeUnit.SECONDS.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println("thread end");
            });
            thread.start();
        }

        try {
            latch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count: "+latch.getCount());
        System.out.println("main thread end");
    }
}
