package com.blb.thread02;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/
public class Demo1 {

    private static Demo1 instance = null;
    private  Demo1(){
        System.out.println("创建对象");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    };

    public static Demo1 getInstance(){
        if(instance == null){
            synchronized (Demo1.class){
                if(instance == null){
                    instance = new Demo1();
                }
            }
        }

        return  instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Demo1 instance = Demo1.getInstance();
                System.out.println(instance.hashCode());

            }).start();
        }
    }
}
