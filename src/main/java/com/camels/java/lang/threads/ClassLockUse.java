package com.camels.java.lang.threads;

import java.util.logging.Logger;

/**
 * @Todo 类锁使用 {@link #getClass()}
 * Created by zhanggc on 2014/10/9.
 */
public class ClassLockUse {

    //等待
    public static void waitOp(){
        try {
            synchronized (ClassLockUse.class){
                ClassLockUse.class.wait();
                Logger.getAnonymousLogger().info("wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //通知
    public static void notifyOp(){
        synchronized (ClassLockUse.class){
            ClassLockUse.class.notifyAll();
            Logger.getAnonymousLogger().info("notify");
        }
    }
}
