package com.blb.locks;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/
public class DeadTest {
    public static void main(String[] args) {
        DeadLocks locks = new DeadLocks();
            new Thread(()->{
               locks.aLock();
            }).start();

            new Thread(()->{
                locks.bLock();
            }).start();

    }
}
