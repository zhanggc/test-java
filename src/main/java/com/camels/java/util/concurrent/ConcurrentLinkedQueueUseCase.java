package com.camels.java.util.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @Todo {@link java.util.concurrent.ConcurrentLinkedQueue} 并发环境下安全
 * Created by zhanggc on 2014/10/21.
 */
public class ConcurrentLinkedQueueUseCase {
    private ConcurrentLinkedQueue<Integer> linkedQueue = new ConcurrentLinkedQueue<Integer>();
    private static CountDownLatch latch = new CountDownLatch(2);

    public void offer(Integer value){
        linkedQueue.offer(value);
    }

    public static void main(String[] args){
        final ConcurrentLinkedQueueUseCase useCase = new ConcurrentLinkedQueueUseCase();
        Thread[] threads = new Thread[2];
        for(int i=0;i++<2;){
            threads[i-1]  = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 1000;
                    for(;count-->0;) {
                        useCase.offer(count);
                    }
                    latch.countDown();
                }
            });
            threads[i-1].start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(useCase.linkedQueue.size());
    }
}
