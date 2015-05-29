package com.camels.java.lang.threads;

/**
 * @Todo 测试中断
 * Created by zhanggc on 2014/10/4.
 */
public class InterruptCase {

    //监测中断状态
    public static void interruptState(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    //睡眠中中断
    public static void interruptOnSleep(){
        Thread.currentThread().interrupt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //等待中中断
    public static void interruptOnWait(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try {
                        synchronized (Thread.currentThread()){
                            Thread.currentThread().wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //持续抛 中断异常
                    Thread.currentThread().interrupt();
                    //修正异常
                    //Thread.currentThread().interrupted();
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    //返回中断状态并清除中断
    public static void interrupted(){
        while(true){
            System.out.println(Thread.currentThread().isInterrupted());
            Thread.currentThread().interrupt();
            Boolean isInterrupted = Thread.interrupted();   //switch interrupted state
            System.out.println(isInterrupted);
        }
    }
}
