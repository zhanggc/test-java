package com.camels.java.util.concurrent;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Todo {@link java.util.concurrent.ConcurrentHashMap} 使用
 * Created by zhanggc on 2014/10/20.
 */
public class ConcurrentHashMapUseCase {
    private ConcurrentHashMap<Integer,Integer> hashMap = new ConcurrentHashMap<Integer,Integer>(16,0.75f,4);
    private static CountDownLatch latch = new CountDownLatch(4);

    public void put(Integer key,Integer value){
        hashMap.put(key,value);
    }

    public static void main(String[] args){
        final ConcurrentHashMapUseCase useCase = new ConcurrentHashMapUseCase();
        Thread[] threads = new Thread[4];
        long start = System.currentTimeMillis();
        final  Random random = new Random();
        for(int i=0;i++<4;){
            threads[i-1]  = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 1000000;
                    for(;count-->0;) {
                        int rand = random.nextInt();
                        useCase.put(rand,rand);
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
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(useCase.hashMap.size());
    }
}
