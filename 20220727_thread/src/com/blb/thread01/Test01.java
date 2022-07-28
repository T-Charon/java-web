package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/
public class Test01 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            long sum = 0;
            for (int i = 1; i <= 10; i++) {
                if(i % 2 ==0){
                    sum+=i;
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->" + sum);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if(i % 2 !=0){
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
        });
        //设置优先级
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
