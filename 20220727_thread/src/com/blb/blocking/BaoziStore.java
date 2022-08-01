package com.blb.blocking;

/**
 * @Author Charon
 * @Date 2022/7/29
 **/


import com.blb.blocking.Baozi;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 包子铺
 */
public class BaoziStore {
    //创建阻塞队列 临界值为50
    private ArrayBlockingQueue<Baozi> baozis = new ArrayBlockingQueue<>(50);
    //做包子
    public  void makeBaozi(){
        //创建包子对象，存入缓冲区
        Baozi baozi = new Baozi(baozis.size());
        try {
            baozis.put(baozi);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产者" + Thread.currentThread().getName() + "做了" + baozi + ",总数：" + baozis.size());

    }

    //拿包子
    public  void takeBaozi(){

        //从缓冲区拿出一个包子
        try {
            Baozi baozi = baozis.take();
            System.out.println("消费者" + Thread.currentThread().getName() + "拿了" + baozi + ",总数：" + baozis.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        BaoziStore store = new BaoziStore();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                store.makeBaozi();
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    store.takeBaozi();
                }
            }).start();
        }
    }




}
