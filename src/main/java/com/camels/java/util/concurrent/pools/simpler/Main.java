package com.camels.java.util.concurrent.pools.simpler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhanggc on 2014/12/30.
 */
public class Main {
    public static void main(String[] args){
      /*  ThreadPool pool =  ThreadPool.newFixedThreadPool(5);
       int count = 0;
        for(;;){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    throw new RuntimeException();
                }
            });
             System.out.println(++count);
        }*/
        ExecutorService pool = Executors.newFixedThreadPool(5);
        int count = 0;
        for(;;){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    throw new RuntimeException();
                }
            });
            System.out.println(++count);
        }
    }
}
