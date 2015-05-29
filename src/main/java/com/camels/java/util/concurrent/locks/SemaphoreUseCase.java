package com.camels.java.util.concurrent.locks;

import java.util.concurrent.Semaphore;

/**
 * @Todo 信号量 {@link java.util.concurrent.Semaphore} 使用
 * @Tips
 *      1. 非重入锁
 *      2. 用作计数
 *      3. 用作阻塞
 * Created by zhanggc on 2014/10/9.
 */
public class SemaphoreUseCase {
    private final Semaphore available;
    private  int cur;

    public SemaphoreUseCase(){
        available = new Semaphore(20);
        cur = 0;
    }

    public SemaphoreUseCase(int available){
        this.available = new Semaphore(available);
        cur = 0;
    }

    public void release(){
        //释放资源
        available.release();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cur--;
    }

    public void take(){
        try {
            //获取资源
            available.acquire();
            Thread.sleep(3000);
            cur++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
