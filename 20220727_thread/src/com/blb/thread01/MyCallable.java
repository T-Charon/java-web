package com.blb.thread01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/
public class MyCallable implements Callable<Long> {
    @Override
    public Long call() throws Exception {
       long sum = 0;
        for (long i = 0; i <10000000000L ; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FutureTask<Long> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();

        Long value = null;
        try {
            value = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
            System.out.println("结果是："+value+",时间是"+(end-start)+"毫秒");



    }
}
