package com.camels.java.util.concurrent.pools;

import java.util.List;
import java.util.Vector;

/**
 * @Todo 线程池
 * Created by zhanggc on 2014/9/7.
 */
public class ThreadPool {
    //闲置线程池
    private List<PThread> idleThreads;
    //总线程数
    private volatile int threadCounter;
    //最大线程数
    private volatile int maxCounter;
    //是否停止
    private volatile boolean isShutdown = false;

    private ThreadPool(){
        this(15);//default 15
    }

    private ThreadPool(int maxCounter){
        this.idleThreads = new Vector<PThread>(5);
        this.threadCounter = 0;
        if(0==maxCounter){
            maxCounter = 15;
        }else this.maxCounter = maxCounter;

    }

    public static synchronized ThreadPool newFixedThreadPool(int maxCounter){
        return  new ThreadPool(maxCounter);
    }

    public static synchronized ThreadPool newFixedThreadPool(){
        return new ThreadPool();
    }

    //执行
    public synchronized void execute(Runnable command){
        for(;!isShutdown;){
            int idleSize = this.getIdleThreads().size();

            //如果有闲置线程直接池中获取
            if(idleSize>0){
                PThread pThread = this.getIdleThreads().get(idleSize-1);
                pThread.setTarget(command);
                this.getIdleThreads().remove(pThread);
                break;

                //如果没有闲置线程且没有达到上限，则创建线程
            }else if(this.threadCounter<this.maxCounter){
                PThread pThread = new PThread(command,this);
                pThread.start();
                this.threadCounter++;
                break;
            }
        }

    }

    //放入闲置池
    public void rePool(PThread pThread){
        if(null!=pThread){
            if(isShutdown){
                pThread.shutdown();
            }else {
                this.getIdleThreads().add(pThread);
            }
        }
    }

    //停止
    public void shutdown(){
        this.isShutdown = true;
        for(PThread pThread:this.getIdleThreads()) pThread.shutdown();
    }

    public List<PThread> getIdleThreads() {
        return idleThreads;
    }

    public int getThreadCounter() {
        return threadCounter;
    }

    public void setThreadCounter(int threadCounter) {
        this.threadCounter = threadCounter;
    }

    public int getMaxCounter() {
        return maxCounter;
    }
}
