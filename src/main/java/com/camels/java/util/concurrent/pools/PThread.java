package com.camels.java.util.concurrent.pools;

import java.util.logging.Logger;

/**
 * @Todo 线程单元
 * Created by zhanggc on 2014/9/7.
 */
public class PThread extends Thread{
    //线程池
    private ThreadPool pool;
    //目标任务
    private Runnable target;
    //是否闲置
    private volatile boolean isIdle = false;
    //是否停止
    private volatile boolean isShutdown = false;

    public PThread(Runnable target,ThreadPool pool){
        this.pool = pool;
        this.target = target;
    }

    @Override
    public synchronized void run() {
        while (!isShutdown){
            //设置繁忙
            isIdle = false;
            if(null!=target) target.run();
            //设置闲置
            isIdle = true;
            //放入闲置线程池
            pool.rePool(this);
            if(isIdle){
                try {
                    //线程进入等待
                    super.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //停止该线程
    public void shutdown(){
        setShutdown(true);
        setIdle(false);
        synchronized (this){
            //唤醒线程
            super.notifyAll();
        }
        Logger.getAnonymousLogger().info(this.getName()+" shutdown !");
    }

    public void setTarget(Runnable target) {
        this.target = target;
        synchronized (this){
            //唤醒线程
            super.notifyAll();
        }
    }

    public void setIdle(boolean isIdle) {
        this.isIdle = isIdle;
    }

    public void setShutdown(boolean isShutdown) {
        this.isShutdown = isShutdown;
    }
}
