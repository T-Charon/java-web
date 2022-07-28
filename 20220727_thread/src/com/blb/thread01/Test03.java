package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/

/**
 * 一个美女正在看电视连续剧，从第1~88集，看到第10集时，来了一个送快递的，美女收完快递后后，继续看电视。
 */
public class Test03 {
    private static Thread t1=null,t2=null;


    public static void main(String[] args) {
        t2 = new Thread(()->{
            System.out.println(t2.getName()+"--正在收快递----");

        });
        t1 = new Thread(()->{
            for (int i = 1; i <= 88 ; i++) {
                System.out.println(Thread.currentThread().getName()+"正在看电视，当前--->"+i+"集");
                if(i == 10){
                    try {
                        t2.start();
                        t2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        t1.setName("美女");
        t2.setName("--");
        t1.start();



    }
}
