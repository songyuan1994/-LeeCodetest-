package com.mashibing.test;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Thin'k'pa'd
 * Volatile关键字的测试
 */
public class VolatileDemo {
    private static volatile VolatileDemo INSTANCE;

    private VolatileDemo() {
    }

    public static VolatileDemo getInstance() {
        if (INSTANCE == null) {
            synchronized (VolatileDemo.class) {
                if (INSTANCE == null){
                    try{
                        Thread.sleep(1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    INSTANCE = new VolatileDemo();
                }
            }
        }
        AtomicInteger integer = new AtomicInteger(0);
        integer.incrementAndGet();
        return INSTANCE;
    }


}
