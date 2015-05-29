package com.camels.java.util.concurrent.unsafe;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 *  @Todo {@link java.util.HashMap} 在并发环境下不安全
 * Created by zhanggc on 2014/10/20.
 */
public class HashMapUseCase {

    private HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
    private static CountDownLatch latch = new CountDownLatch(3);

    public void put(Integer key,Integer value){
        hashMap.put(key,value);
    }

    public static void main(String[] args){
        final HashMapUseCase useCase = new HashMapUseCase();
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[3];
        for(int i=0;i++<3;){
            threads[i-1]  = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 10000;
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
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(useCase.hashMap.size());
    }
}
