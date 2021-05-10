package com.mashibing.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterrputLockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);

        Thread t1 = new Thread(() ->{
          try{
              lock.lock();
              System.out.println("Thread1 lock");
              TimeUnit.SECONDS.sleep(10);
              System.out.println("Thread1 end");
          }catch (Exception e){
              e.printStackTrace();
          }finally {
              lock.unlock();
              System.out.println("lockTest----current thread release the lock:  " + Thread.currentThread().getName());
          }
        });

        t1.start();

        Thread t2 = new Thread(() ->{
            try{
                lock.lockInterruptibly();
                System.out.println("Thread2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Thread2 end");
            }catch (Exception e){
                System.out.println("lock interrupt");
                //e.printStackTrace();
            }finally {
                System.out.println("finally interrupt lock");
                //lock.unlock();
            }
        });
        t2.start();

        System.out.println("try interrupt");
        t2.interrupt();


    }
}
