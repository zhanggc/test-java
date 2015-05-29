package com.camels.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Todo 调用 {@link #wait()} 方法时，通过 {@code Lock}  代替 {@code synchronized}获取锁 (证明不能代替)
 * Created by zhanggc on 2014/10/8.
 */
public class LockReplaceSynOnObject {
    private  final ReentrantLock lock = new ReentrantLock();

    public  void lockNotSynOnWait(){
        try {
            lock.lock();
            wait();
       } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void  lockNotSynOnNotify(){
        try {
            lock.lock();
            notify();
        } finally {
            lock.unlock();
        }
    }

}

