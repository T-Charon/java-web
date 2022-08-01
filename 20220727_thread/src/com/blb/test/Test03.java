package com.blb.test;

/**
 * @Author Charon
 * @Date 2022/7/31
 **/



import com.blb.blocking.Baozi;
import com.blb.blocking.BaoziStore;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 3. 模拟卖火车票，4个窗口共卖100张票 ，100个人来抢
 */
//窗口
public class Test03 {


    public  int tickets = 100;//总票数
    public  int ticketIndex = 1;//票号


    //窗口卖票
    public  void window(){
        while (tickets > 0){
            synchronized(this){
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);//模拟售票需要一定的时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"==>"+(this.tickets - this.ticketIndex+1));
                    tickets--;

                }else {
                    break;//结束售票
                }
            }

        }

    }

    //买票
    public synchronized void takeTicket(){
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "购买了第" + ticketIndex + "号票");
            ticketIndex++;
            tickets--;
            return;
        }
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();

//        for (int i = 0; i < 4; i++) {
//            new Thread(() -> {
//                test03.window();
//
//            }).start();
//        }



        for (int j = 1; j <= 100 ; j++) {
            Thread thread = new Thread(() -> {
                test03.takeTicket();
            });
            thread.setName("顾客"+j);
            thread.start();
        }

    }

}
