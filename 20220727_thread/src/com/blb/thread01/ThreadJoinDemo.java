package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/

/**
 * 合并线程
 */
public class ThreadJoinDemo {
    private static Thread t1= null,t2=null;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"---->"+i);
                try {
                    if(i == 5){
                        t2.join();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("老奶奶");
        t1.start();

        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"---->"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setName("小靳");
        t2.start();
    }
   
    
}
