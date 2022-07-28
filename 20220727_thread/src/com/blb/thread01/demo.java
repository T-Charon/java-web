package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/
public class demo {
    public static void main(String[] args) {
        // TuThread t = new TuThread();
        // Thread w = new Thread(new WuRunnable());
        // t.start();
        // w.start();
        Result r = new Result();
        new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("乌龟跑了" + i + "米");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                if (i >= 1000) {
                    r.isWin = true;
                    System.out.println("乌龟胜利了" + i);
                    break;
                }
                if (i % 100 == 0) {
                    try {
                        System.out.println("乌龟在"+i+"米处开始休息");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            int m = 0;
            for (int j = 1; j <= 200; j++) {
                if(r.isWin){
                    System.out.println("兔子跑了" + m + "米............");
                    break;
                }
                m += 5;
                System.out.println("兔子跑了" + m + "米");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                if (m >= 1000) {
                    System.out.println("兔子胜利了" + j);

                }
                if (m % 20 == 0) {
                    try {
                        System.out.println("兔子在"+j*5+"米处开始休息");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
class Result{
    boolean isWin = false;
}



