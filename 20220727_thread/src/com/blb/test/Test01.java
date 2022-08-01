package com.blb.test;

/**
 * @Author Charon
 * @Date 2022/7/30
 **/

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 1. 编写一个程序，开启3个线程，这3个线程的ID分别为A、B、C，每个线程将自己的ID在屏幕上打印10遍，
 * 要求输出结果必须按ABC的顺序显示；如：ABCABC….依次递推
 */
public class Test01 {

    public  synchronized void aThread(){
       for (int i = 0; i < 10; i++) {
           System.out.println(Thread.currentThread().getName()+"我是A线程");
           try {
               this.wait(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       //停止程序
       try {
           this.wait();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

   };

    public synchronized void bThread(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"我是B线程");
            try {
                this.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //停止程序
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    };

    public  synchronized void cThread(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"我是C线程");
            try {
                this.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //停止程序
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        new Thread(()->test01.aThread()).start();
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->test01.bThread()).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->test01.cThread()).start();
    }
}
