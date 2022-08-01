package com.blb.consumer01;

/**
 * @Author Charon
 * @Date 2022/7/29
 **/

import com.blb.consumers.Baozi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 包子铺
 */
public class BaoziStore {
    //创建锁对象
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //临界值
    public static final int MAX_SIZE = 50;
    //缓冲区
    private List<Baozi> baozis = new ArrayList<>();

    //做包子
    public  void makeBaozi(){
        try {
        //上锁
            lock.lock();
            //如果缓冲区满了，生产者等待
            if(baozis.size() == MAX_SIZE){
                System.out.println("包子铺满了，生产者"+Thread.currentThread().getName()+"等待");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                //通知所有消费者
                condition.signalAll();
            }
            if(baozis.size() < MAX_SIZE) {
                //创建包子对象，存入缓冲区
                Baozi baozi = new Baozi(baozis.size());
                baozis.add(baozi);
                System.out.println("生产者" + Thread.currentThread().getName() + "做了" + baozi + ",总数：" + baozis.size());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            lock.unlock();
        }

    }

    //拿包子
    public  void takeBaozi(){

        try {
            lock.lock();
            //如果缓冲区空了，消费者等待
            if(baozis.size() == 0){
                System.out.println("包子铺空了，消费者"+Thread.currentThread().getName()+"等待");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                //通知生产者生产
                try {
                    condition.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(baozis.size() > 0){
                //从缓冲区拿出一个包子
                Baozi baozi = baozis.remove(0);
                System.out.println("消费者" + Thread.currentThread().getName() + "拿了" + baozi + ",总数：" + baozis.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public static void main(String[] args) {
        com.blb.consumers.BaoziStore store = new com.blb.consumers.BaoziStore();
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
