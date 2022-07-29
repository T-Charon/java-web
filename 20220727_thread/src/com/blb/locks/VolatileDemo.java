package com.blb.locks;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/

import com.blb.thread01.demo;

/**
 * 线程可见性多线程的执行过程中，每个线程有自己的工作内存，线程会从主内存中加载数据到工作内存中，
 * 修改工作内存的数据后，其它线程是看不到最新的数据的，直到线程将新数据写回到主内存为止，
 * 中间存在线程间数据不一致的问题。
 * 解决方法：变量前加volatile
 */
public class VolatileDemo {
    private volatile boolean run = true;

    public void test(){
        System.out.println("start!");
        while(run){}
        System.out.println("end!");
    };

    public static void main(String[] args) {
        VolatileDemo demo = new VolatileDemo();
        new Thread(()->{
            demo.test();
        }).start();

        //2秒后修改run的状态
        try {
            Thread.sleep(2000);
            demo.run=false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
