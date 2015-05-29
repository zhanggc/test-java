package com.camels.java.util.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

/**
 * @Todo 读写锁测试
 * @Tip
 * 线程间：
 * - 读锁是排写锁，读锁不排读锁
 * - 写锁是排写锁、读锁
 *
 * 本线程内：
 * - 写锁不排读锁
 * - 读锁排写锁
 * Condition 只能写锁拥有
 *
 * Created by zhanggc on 2014/10/8.
 */

public class TestReadWriteLock {
    private static final ReentrantReadWriteLock readWriteLock;
    private static final Lock readlock;
    private static final Lock writelock;

    static{
        readWriteLock = new ReentrantReadWriteLock();
        readlock = readWriteLock.readLock();
        writelock = readWriteLock.writeLock();
    }

    public static void main(String[] args){
        write();
    }

    /**
     * @Todo 多线程间：读锁排写锁
     * @return
     */
    public static void readExcludeWriteWithMulti(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                read();
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
                write();
            }
        }).start();
    }

    /**
     * @Todo 多线程间：读锁不排读锁
     * @return
     */
    public static void readIncludeReadWithMulti(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                read();
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
                read();
            }
        }).start();
    }


    /**
     * @Todo 多线程间：写锁排读锁
     * @return
     */
    public static void writeExcludeReadWithMulti(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                write();
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
                read();
            }
        }).start();
    }


    /**
     * @Todo 多线程间：写锁排写锁
     * @return
     */
    public static void writeExcludeWriteWithMulti(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                write();
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
                write();
            }
        }).start();
    }


    /**
     * @Todo 本线程内：写锁不排读锁
     * @return
     */
    public static void writeIncludeReadWithSingle(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    writelock.lock();
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" write");
                    Thread.sleep(2000);
                    readlock.lock();
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" read");
                    Thread.sleep(2000);
                    readlock.unlock();
                    writelock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * @Todo 本线程内：读锁排写锁
     * @return
     */
    public static void readExcludeWriteWithSingle(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readlock.lock();
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" read");
                    Thread.sleep(2000);
                    writelock.lock();
                    Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" write");
                    Thread.sleep(2000);
                    writelock.unlock();
                    readlock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //读操作
    public static void write(){
        try{
        writelock.lock();
            Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" write");
            try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }finally {
            writelock.unlock();
        }
    }

    //写操作
    public static void read(){
        try{
            readlock.lock();
            Logger.getAnonymousLogger().info(Thread.currentThread().getName()+" read");
            try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }finally {
            readlock.unlock();
        }
    }
}
