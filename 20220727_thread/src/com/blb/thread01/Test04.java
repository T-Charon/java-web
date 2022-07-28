package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/

/**
 * 4. 多线程模拟龟兔赛跑：
 * ​乌龟和兔子进行1000米赛跑，兔子前进5米，乌龟只能前进1米。
 * ​但兔子每20米要休息500毫秒，而乌龟是每100米休息500毫秒。
 * ​谁先到终点就结束程序，并显示获胜方
 */
public class Test04 {
    private static Thread t1=null,t2=null;

    public static void main(String[] args) {

        t1 =new Thread(()->{
            for (int i = 0; i <= 1000; i+=5) {
                System.out.println("兔子跑了"+i+"米");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i%20==0 ){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("兔子赢了");
            System.exit(0);
        });

        t2 =new Thread(()->{
            for (int i = 0; i <= 1000; i++) {
                System.out.println("乌龟跑了"+i+"米");
                try {
                    Thread.sleep(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i%100==0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("乌龟赢了");
            System.exit(0);
        });
        t1.start();
        t2.start();


    }

}
