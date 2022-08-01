package com.blb.test;

/**
 * @Author Charon
 * @Date 2022/7/30
 **/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. 编写一个程序，开启3个线程，这3个线程的ID分别为A、B、C，每个线程将自己的ID在屏幕上打印10遍，
 * 要求输出结果必须按ABC的顺序显示；如：ABCABC….依次递推
 */
public class Test01_1 {
    //创建锁对象
    private  Lock lock = new ReentrantLock();
    private volatile String flag = null;


    public   void aThread(){
       for (int i = 0; i < 10; i++) {
           lock.lock();
           System.out.println(Thread.currentThread().getName()+"我是A线程");
           if(flag == null){
               flag = "b";
               try {
                   lock.unlock();
                   lock.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }


   };

    public  void bThread(){
        for (int i = 0; i < 10; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"我是B线程");
            if(flag == "b"){
                flag = "c";
                try {
                    lock.unlock();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    };

    public   void cThread(){
        for (int i = 0; i < 10; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"我是C线程");
            if(flag == "c"){
                flag = null;
                try {
                    lock.unlock();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    };

    public  void testNotify(){
        lock.notifyAll();
    };



    public static void main(String[] args) {
        Test01_1 test01 = new Test01_1();
        new Thread(()->test01.aThread()).start();

        new Thread(()->test01.bThread()).start();

        new Thread(()->test01.cThread()).start();
    }
}
