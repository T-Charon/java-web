package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/

/**
 * 后台线程
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread deamon = new Thread(() -> {
            for (int i = 0; ; i++) {
                System.out.println(Thread.currentThread().getName() + "---->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        deamon.setName("守护线程");
        deamon.setDaemon(true);
        deamon.start();
        //设置被守护线程


        //被守护线程
        for (int i = 0; i < 3; i++) {
            Thread deamon1 = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + "---->" + j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            deamon1.start();
        }
    }
}
