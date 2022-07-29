package com.blb.locks;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/
public class Demo {
    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
