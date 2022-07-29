package com.blb.waitandnotify;



/**
 * @Author Charon
 * @Date 2022/7/29
 **/
public class WaitDemo {
    public synchronized void testWait(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public synchronized void testNotify(){
       this.notify();
    };


    public static void main(String[] args) {
        WaitDemo demo = new WaitDemo();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"执行了"+i);
                if(i == 5){
                    System.out.println(Thread.currentThread().getName()+"开始等待");
                    demo.testWait();
                }

            }
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{

            demo.testNotify();

        }).start();
    }
}
