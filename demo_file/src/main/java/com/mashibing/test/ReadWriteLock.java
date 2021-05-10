package com.mashibing.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;


public class ReadWriteLock {
    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public static ReadLock readLock = reentrantReadWriteLock.readLock();
    public static WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        LongAdder adder = new LongAdder();
        for(int i=0;i<5;i++){
            ReadThread thread = new ReadThread("readThread"+i);
            thread.start();
        }
        for(int i=0;i<2;i++){
            WriteThread thread = new WriteThread();
            thread.start();
        }

    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            readLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+" begin");
                TimeUnit.SECONDS.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                readLock.unlock();
            }
            System.out.println(Thread.currentThread().getName()+" end");
        }

        public ReadThread(String name){
            super(name);
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            writeLock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+" begin");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                writeLock.unlock();
            }
            System.out.println(Thread.currentThread().getName()+" end");
        }
    }
}
