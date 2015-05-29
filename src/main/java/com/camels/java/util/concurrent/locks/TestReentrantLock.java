package com.camels.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * @Todo {@link java.util.concurrent.locks.ReentrantLock} 基本使用
 * @Tips
 *      1) 可响应中断
 * Created by zhanggc on 2014/10/4.
 */
public class TestReentrantLock {
    private static final ReentrantLock lock;
    static {
        lock = new ReentrantLock();//equal new ReentrantLock(false)
        //lock = new ReentrantLock(true); fair lock
    }
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock();
            }
        },"Main Thread one");
        thread.start();
        thread.interrupt();
    }

    public static void lock(){
        lock.lock();
        try {
            Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" lock");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" unlock");
    }

    //响应中断锁
    public static void lockInterrupt(){
        try {
            lock.lockInterruptibly();
            Thread.sleep(5000); //wait for interrputing
        } catch (InterruptedException e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" interrupt");
        }
    }

    //尝试锁
    public static void tryLock(){
            if(lock.tryLock()){
            try{
            Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" get lock");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        }else{
            Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" lose lock");
        }
    }

    //lock 与 synchronized 直接不会存在对monitor竞争
    public static synchronized void synchronize(){
        try {
            Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" synchronized");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
