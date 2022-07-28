package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/

/**
 * 自定义线程
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println(Thread.currentThread().getName()+"------>"+i);
        }
    }

    public static void main(String[] args) {
        //创建线程
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        //启动

        myThread.start();
        myThread1.start();
        myThread2.start();
        myThread.run();




//        for (int i = 0; i < 20; i++) {
//            System.out.println(Thread.currentThread().getName()+"------>"+i);
//        }

    }
}
