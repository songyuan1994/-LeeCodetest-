package com.mashibing.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Thin'k'pa'd
 * 可重入锁demo
 *
 */
public class ReentrankLockDemo implements Runnable{
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        ReentrankLockDemo demo = new ReentrankLockDemo();
        for(int i=0;i<5;i++){
            Thread thread = new Thread(demo,"Thread"+i);
            thread.start();
        }
    }

    @Override
    public void run(){
        System.out.println("begin run,Thread="+Thread.currentThread().getName());
        reentrantLock.lock();
        try{
            Thread.sleep(100);
            System.out.println("run start,Thread="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
