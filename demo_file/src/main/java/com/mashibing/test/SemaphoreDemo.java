package com.mashibing.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Thin'k'pa'd
 * 信号量相关代码
 */
public class SemaphoreDemo {
    public static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for(int i=0;i<15;i++){
            Thread thread = new Thread(new ThreadDemo());
            thread.start();
        }
        System.out.println("Main thread end");
    }

    static class ThreadDemo implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Thread start");
            try {
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + " Thread end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
