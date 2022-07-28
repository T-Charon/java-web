package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println(Thread.currentThread().getName()+"------>"+i);
        }
    }

    public static void main(String[] args) {
        //创建thread对象 创建runnable对象
        Thread thread = new Thread(new MyRunnable());
        //启动线程
        thread.start();

        //匿名内部类
        Thread thread1 = new Thread(new MyRunnable()) {
            @Override
            public void run() {
                for (int i = 0; i <10; i++) {
                    System.out.println(Thread.currentThread().getName()+"------>"+i);
                }
            }
        };

        thread1.start();

        //lambda表达式
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "------>" + i);
            }
        }).start();
    }
}
