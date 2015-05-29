package com.camels.java.util.concurrent.unsafe;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @Todo {@link java.util.ArrayList} 并发环境下不安全
 * Created by zhanggc on 2014/10/20.
 */
public class ArrayListUseCase {
    private ArrayList<Integer> arraylist = new ArrayList<Integer>();
    private static CountDownLatch latch = new CountDownLatch(2);

    public void add(Integer value){
        arraylist.add(value);
    }

    public static void main(String[] args){
        final ArrayListUseCase useCase = new ArrayListUseCase();
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
