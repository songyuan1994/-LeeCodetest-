package com.mashibing.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Thin'k'pa'd
 * 淘宝面试题：
 * 实现一个容器，提供两个方法，add,size
 * 写两个线程，线程1添加10个元素到容器中，线程2监控容器数量
 * 当个数到5时，线程2给出提示并结束。
 */
public class TwoThreadCommunicateDemo {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        DemoList demoList = new DemoList();
        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock2) {
                    try {
                        if (i == 5) {
                            lock2.notify();
                        }
                        demoList.add(i);
                        System.out.println(i);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Thread is interrupt,DemoList=" + JSON.toJSONString(demoList));
                    }
                }
            }
        });
        //t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (lock2){
                if (demoList.size != 5) {
                    System.out.println("Interrupt");
                    try {
                        lock2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread2 end");
                }
            }
        });
        t2.start();
        Thread.sleep(1000);
        t1.start();
    }

    static class DemoList {
        private List<Integer> list = new ArrayList<>();
        private volatile int size = 0;

        public DemoList() {
        }

        public void add(Integer num) {
            list.add(num);
            size++;
        }
    }
}
