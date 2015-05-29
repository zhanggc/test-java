package com.camels.java.util.concurrent.locks;

/**
 * @Todo 调用 {@link #wait()} 方法时，通过 {@code Lock}  代替 {@code synchronized}获取锁 (证明不能代替)
 * Created by zhanggc on 2014/10/8.
 */
public class TestLockReplaceSynOnObject {

    public static void main(String[] args){
        final LockReplaceSynOnObject lockReplaceSynOnObject = new LockReplaceSynOnObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockReplaceSynOnObject.lockNotSynOnWait();
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockReplaceSynOnObject.lockNotSynOnNotify();
            }
        }).start();
    }
}
