package com.camels.java.lang.threads;

import java.util.concurrent.TimeUnit;

/**
 * @Que
 * @Todo 线程状态
 * Created by zhanggc on 2014/10/4.
 */
public class ThreadState {
    private static volatile boolean isSetWaiting = false;
    private static volatile boolean isSetTimedWaiting = false;
    private static volatile boolean isSetTerminated = false;
    private static volatile boolean isSetSleep = false;
    private static volatile boolean isSetBlocked = false;
    private static volatile boolean isSetRunnable = false;

    public static void main(String[] args){
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (; ; ) {
                        System.out.print("run...");
                        if (isSetWaiting) {
                            synchronized (Thread.currentThread()) {
                                try {
                                    Thread.currentThread().wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if (isSetTimedWaiting) {
                            synchronized (Thread.currentThread()) {
                                try {
                                    Thread.currentThread().wait(10000, 0);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if(isSetSleep){
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (isSetTerminated) {
                            break;
                        }
                    }
                }
        });

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (thread){
                    try {
                        thread.wait();
                        for(;;){
                            if(isSetTerminated){
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        newState(thread);
        runnableState(thread);
        waitState(thread);
        waitTimeState(thread);
        try {
            thread1.start();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blockState(thread, thread, thread1);
        terminateState(thread);
    }

    public static void newState(Thread thread){
        Thread.State state = thread.getState();
        System.out.println(state);
    }

    public static void runnableState(Thread thread){
        thread.start();
        Thread.State state = thread.getState();
        System.out.println(state);
    }

    public static void waitState(final Thread thread){
        isSetWaiting = true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.State state = thread.getState();
        System.out.println("\n"+state);
        isSetWaiting = false;
        synchronized (thread){
            thread.notifyAll();
        }
    }
    public static void waitTimeState(final Thread thread){
        isSetTimedWaiting = true;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.State state = thread.getState();
        System.out.println("\n"+state);
        isSetTimedWaiting = false;
    }

    public static void blockState(final Object obj,final Thread ... threads){
        synchronized (obj){
            obj.notifyAll();
        }
        long start = System.currentTimeMillis();
        for(;System.currentTimeMillis()-start<10000;){
            for(Thread thread:threads){
                Thread.State state = thread.getState();
                System.out.println("\n"+state);
            }
        }
    }

    public static void terminateState(final Thread thread){
        System.out.println("\n isAlive:"+thread.isAlive());
        isSetTerminated = true;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.State state = thread.getState();
        System.out.println("\n"+state);
        System.out.println("\n isAlive:"+thread.isAlive());
    }
}
