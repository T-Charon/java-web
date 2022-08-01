package com.blb.threadlocal;

/**
 * @Author Charon
 * @Date 2022/7/29
 **/
public class MyThreadLocal {
    static volatile int value = 1;

    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue(){
                return 1;
            }
        };

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                value ++;
                local.set(local.get()+1);

            }
            System.out.println("value="+value);
            System.out.println("local="+local.get());
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("value="+value);
        System.out.println("local="+local.get());

    }


}
