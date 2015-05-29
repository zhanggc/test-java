package com.camels.java.lang.threads;

import com.camels.java.lang.threads.ClassLockUse;

/**
 * @Todo 类锁使用 {@link #getClass()}
 * Created by zhanggc on 2014/10/9.
 */
public class TestClassLockUse {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ClassLockUse.waitOp();
            }
        }).start();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                ClassLockUse.notifyOp();
            }
        }).start();
    }
}
