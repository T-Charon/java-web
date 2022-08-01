package com.blb.consumers;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/29
 **/
public class BaoziStore {
    //临界值
    public static final int MAX_SIZE = 50;
    //缓冲区
    private List<Baozi> baozis = new ArrayList<>();

    //做包子
    public synchronized void makeBaozi(){
        //如果缓冲区满了，生产者等待
        if(baozis.size() == MAX_SIZE){
            System.out.println("包子铺满了，生产者"+Thread.currentThread().getName()+"等待");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            //通知所有消费者
            this.notifyAll();
        }
        if(baozis.size() < MAX_SIZE) {
            //创建包子对象，存入缓冲区
            Baozi baozi = new Baozi(baozis.size());
            baozis.add(baozi);
            System.out.println("生产者" + Thread.currentThread().getName() + "做了" + baozi + ",总数：" + baozis.size());
        }
    }

    //拿包子
    public synchronized void takeBaozi(){
        //如果缓冲区空了，消费者等待
        if(baozis.size() == 0){
            System.out.println("包子铺空了，消费者"+Thread.currentThread().getName()+"等待");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            //通知生产者生产
            this.notifyAll();
        }
        if(baozis.size() > 0){
            //从缓冲区拿出一个包子
            Baozi baozi = baozis.remove(0);
            System.out.println("消费者" + Thread.currentThread().getName() + "拿了" + baozi + ",总数：" + baozis.size());
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
