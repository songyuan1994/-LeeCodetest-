package com.mashibing.test;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author Thin'k'pa'd
 * 分段式锁：LongAdder
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(10);
        System.out.println(longAdder.sum());
    }
}
