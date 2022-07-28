package com.blb.thread01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/

/**
 * 1. 设计两个线程，一个线程负责求出1~１０以内所有的偶数；然后，另外一个线程负责打印1~１０以内所有的奇数。
 *   测试时，分别设置线程的优先级，观察执行的顺序。
 */
public class TestThread01 implements Callable<Long> {
    private static Thread t1 = null,t2=null;
    @Override
    public Long call() throws Exception {
        //查询1-10之间的偶数
        long sum = 0;
        for (int i = 1; i <= 10; i++) {
            if(i % 2 ==0){
                sum+=i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FutureTask<Long> futureTask = new FutureTask<>(new TestThread01());
        t1 = new Thread(futureTask);
        t2 = new Thread(futureTask);
        t1.setName("计算偶数");
        t2.setName("打印奇数");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

        for (int i = 1; i <= 10 ; i++) {
            if(i%2 != 0){
                System.out.println(t2.getName()+"=====>"+i);
            }
        }
        try {
            Long value = futureTask.get();
            System.out.println(t1.getName()+"=====>"+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }







    }


}
