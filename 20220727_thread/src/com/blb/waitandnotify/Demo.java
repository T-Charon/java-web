package com.blb.waitandnotify;

/**
 * @Author Charon
 * @Date 2022/7/29
 **/

/**
 * 线程的交替输出，线程1负责输出A，线程2负责输出B，两个线程同时执行打印出ABABAB..
 */
public class Demo {

    public synchronized void aThread(){
        while(true){
            this.notify();
            System.out.println(Thread.currentThread().getName()+"线程执行A");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public synchronized void bThread(){
        while(true){
            this.notify();
            System.out.println(Thread.currentThread().getName()+"线程执行B");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(demo::aThread).start();

        new Thread(demo::bThread).start();

    }
}
