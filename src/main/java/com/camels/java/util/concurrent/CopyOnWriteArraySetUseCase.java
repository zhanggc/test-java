package com.camels.java.util.concurrent;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

/**
 * @Todo {@link java.util.concurrent.CopyOnWriteArraySet} 使用
 * Created by zhanggc on 2014/10/20.
 */
public class CopyOnWriteArraySetUseCase {
    private CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<Integer>();
    private static CountDownLatch latch = new CountDownLatch(2);

    public void add(Integer value){
        copyOnWriteArraySet.add(value);
    }

    public static void main(String[] args){
        final CopyOnWriteArraySetUseCase useCase = new CopyOnWriteArraySetUseCase();
        Thread[] threads = new Thread[2];
        for(int i=0;i++<2;){
            threads[i-1]  = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 1000;
                    for(;count-->0;) {
                        useCase.add(count);
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
        System.out.println(useCase.copyOnWriteArraySet.size());
    }
}
