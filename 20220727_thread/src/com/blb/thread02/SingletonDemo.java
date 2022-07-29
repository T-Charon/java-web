package com.blb.thread02;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/
public class SingletonDemo {
    public static void main(String[] args) {
        //多线程环境下的单例模式
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
//                HungrySingleton instance = HungrySingleton.getInstance();
//                System.out.println("饿汉"+instance.hashCode());
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println("懒汉"+instance.hashCode());
            }).start();
        }
    }
}
