package com.camels.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Todo 多个 {@link java.util.concurrent.locks.Lock} 在同一个资源上
 * Created by zhanggc on 2014/10/11.
 */
public class MultiLockOnResource {
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args){
        final MultiLockOnResource multiLock = new MultiLockOnResource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                multiLock.lock1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                multiLock.lock2();
            }
        }).start();
    }

    public void lock1(){
        lock1.lock();
        for(;;){}
    }
    public void lock2(){
        lock2.lock();
        for(;;){
        }
    }
}
