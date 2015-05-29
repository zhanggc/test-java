package com.camels.java.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhanggc on 2014/11/11.
 */
public class ConcurrentGeekMapTest {

    public static void main(String[] args){
        final  CountDownLatch latch = new CountDownLatch(10);
        final ConcurrentGeekMap geekMap = new ConcurrentGeekMap<Integer,Integer>();
        final int count = 10;

        for(int k = count;--k>-1;){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=count;--i>0;){
                        for(int j=count;--j>0;) {
                            geekMap.put(j, j);
                        }
                    }
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
            System.out.println(geekMap.indexs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
