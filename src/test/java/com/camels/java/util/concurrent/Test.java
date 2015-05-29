package com.camels.java.util.concurrent;

import java.util.logging.Logger;

/**
 * Created by zhanggc on 2014/9/30.
 */
public class Test {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;)
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName());
            }
        }).start();
    }
}
