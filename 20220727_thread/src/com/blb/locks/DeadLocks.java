package com.blb.locks;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/

import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁
 */
public class DeadLocks {
    private  Object a = new Object();
    private  Object b = new Object();

    public  void aLock(){

        synchronized (b){
            System.out.println(Thread.currentThread().getName()+"持有锁b，需要锁a");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"持有锁a与b结束");
            }
        }
    };

    public  void bLock(){
        synchronized (a){
            System.out.println(Thread.currentThread().getName()+"持有锁b，需要锁a");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"持有锁a与b,结束");
            }
        }
    };

}
