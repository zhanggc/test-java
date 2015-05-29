package com.camels.java.util.concurrent.locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Todo 介绍 {@link java.util.concurrent.locks.Condition} 使用
 * tips
 *      1. http://ifeve.com/understand-condition/#more-9789
 *      2. 多线程间协调通信的工具类
 *      3. Object wait、notify、notifyall 代替品
 * Created by zhanggc on 2014/10/8.
 */
public class ConditionUseCase<T>{

    private final ArrayList<T> taskList;
    private final int maxCount;
    private final Lock lock = new ReentrantLock();
    private final Condition consumer;
    private final Condition producer;

    public ConditionUseCase(){
        maxCount = 20;
        taskList = new ArrayList<T>(maxCount);
        consumer = lock.newCondition();
        producer = lock.newCondition();
    }

    public ConditionUseCase(int maxCount){
        if(0==maxCount) throw new IllegalArgumentException("maxCount 参数 不能为 0 ！");
        this.maxCount = maxCount;
        taskList = new ArrayList<T>(maxCount);
        consumer = lock.newCondition();
        producer = lock.newCondition();
    }

    //producer 生产
    public void put(T t){
        try{
            lock.lock();
            for(;taskList.size()>=maxCount;){
                try {
                    //唤醒消费者
                    consumer.signal();
                    //生产者等待
                    producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    producer.signal();
                }
            }
            taskList.add(t);
        }finally {
            lock.unlock();
        }
    }

    //consumer 消费
    public T take(){
        T t;
        try{
            lock.lock();
                for(;0==taskList.size();) {
                    try {
                        //唤醒生产者
                        producer.signal();
                        //消费者等待
                        consumer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        consumer.signal();
                    }
                }
            t = taskList.remove(taskList.size()-1);
        }finally {
            lock.unlock();
        }
        return t;
    }

    public int size(){
        return taskList.size();
    }
}
