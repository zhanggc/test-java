package com.camels.java.util.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @Todo {@link java.util.Collections.SynchronizedMap} 在并发环境下线程安全
 * Created by zhanggc on 2014/10/20.
 */
public class SynchronizedMapUseCase {
    private Map<Integer,Integer> hashMap = Collections.synchronizedMap(new HashMap<Integer,Integer>());
    private static CountDownLatch latch = new CountDownLatch(2);

    public void put(Integer key,Integer value){
        hashMap.put(key,value);
    }

    public static void main(String[] args){
        final SynchronizedMapUseCase useCase = new SynchronizedMapUseCase();
        Thread[] threads = new Thread[2];
        for(int i=0;i++<2;){
            threads[i-1]  = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 1000;
                    for(;count-->0;) {
                        useCase.put(count,count);
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
        System.out.println(useCase.hashMap.size());
    }
}
