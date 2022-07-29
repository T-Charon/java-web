package com.blb.locks;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类
 */
public class AtomicDemo {
    private static int count = 0;
    private static AtomicInteger aCount= new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(()->{
//                count ++;
                aCount.getAndIncrement();
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(aCount.intValue());
    }
}
