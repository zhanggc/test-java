package com.camels.java.util.concurrent.unsafe;

/**
 * @Todo 重用 变量结果 {reuse} ,value1=reuse
 * Created by zhanggc on 2014/10/17.
 */
public class ReuseResultInContext {
    private static int value = 0;

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int reuse = value*3;
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int value1 = value*3;
                System.out.print(value1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value = 3;
            }
        }).start();
    }
}
