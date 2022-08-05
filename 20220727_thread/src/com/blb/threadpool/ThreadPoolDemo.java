package com.blb.threadpool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author Charon
 * @Date 2022/8/2
 * 线程池
 **/
public class ThreadPoolDemo {
    //长度不限的线程池
    public static void testCachedThreadPool(){

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            final int x = i;
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"==>"+x);
            });
        }
        pool.shutdown();
    }

    //长度固定的线程池
    public static void testFixedThreadPool(){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 500; i++) {
            final int x = i;
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"==>"+x);
            });
        }
        pool.shutdown();
    }

    //创建可调度的线程池
    public static void testScheduleExecutorService(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
//        pool.scheduleWithFixedDelay(()->{
//            System.out.println(Thread.currentThread().getName()+"==>"+new Date());
//        },5,1, TimeUnit.SECONDS);




        pool.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName()+"==>"+new Date());
        },5,1, TimeUnit.SECONDS);
    }
    public static void main(String[] args) {
//          testCachedThreadPool();
////        testFixedThreadPool();
        testScheduleExecutorService();
    }
}
