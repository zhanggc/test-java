package com.camels.java.util.concurrent.unsafe;

import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

/**
 * @Todo {@link java.util.HashSet} 在并发环境下不安全
 * Created by zhanggc on 2014/10/20.
 */
public class HashSetUseCase {
    private HashSet<Integer> hashSet = new HashSet<Integer>();
    private static CountDownLatch latch = new CountDownLatch(2);

    public void add(Integer value){
        hashSet.add(value);
    }

    public static void main(String[] args){
        final HashSetUseCase useCase = new HashSetUseCase();
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
        System.out.println(useCase.hashSet.size());
    }
}
