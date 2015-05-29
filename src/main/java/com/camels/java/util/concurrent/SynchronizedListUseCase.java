package com.camels.java.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Todo {@link java.util.Collections.SynchronizedList} 在并发环境下线程安全
 * Created by zhanggc on 2014/10/20.
 */
public class SynchronizedListUseCase {
    private List<Integer> arraylist = Collections.synchronizedList(new ArrayList<Integer>());
    private static CountDownLatch latch = new CountDownLatch(2);

    public void add(Integer value){
        boolean flag = false;
        while (!flag)
            flag = arraylist.add(value);
    }

    public static void main(String[] args){
        final SynchronizedListUseCase useCase = new SynchronizedListUseCase();
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
        System.out.println(useCase.arraylist.size());
    }
}
