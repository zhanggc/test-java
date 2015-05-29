package com.camels.java.lang.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Todo 死锁介绍
 * Created by zhanggc on 2014/10/11.
 */
public class DeadLock {
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args){
        final DeadLock deadLock1 = new DeadLock();
        final DeadLock deadLock2 = new DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock1.lock();
                    Thread.sleep(1000);
                    deadLock2.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    deadLock1.unlock();
                    deadLock2.unlock();
                }
            }
        }).start();
        try {
            deadLock2.lock();
            Thread.sleep(1000);
            deadLock1.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            deadLock1.unlock();
            deadLock2.unlock();
        }
    }

    public void lock(){
        lock.lock();
    }

    public void unlock(){
        lock.unlock();
    }
}
