package com.camels.java.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhanggc on 2014/10/13.
 */
public class ReorderAndVolatile {
    private String value;

    private static volatile boolean door = false;
    private static ReorderAndVolatile reorderAndVolatile;

    public static void main(String[] args){
        final CyclicBarrier barrier = new CyclicBarrier(3);
        for(;;){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String value = ReorderAndVolatile.getInstance().value;
                    if(null==value){
                        System.out.println("unsafe and reorder");
                        door = true;
                    }
                    try {
                        barrier.await();
                        System.out.println("await");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String value = ReorderAndVolatile.getInstance().value;
                    if(null==value){
                        System.out.println("unsafe and reorder");
                        door = true;
                    }
                    try {
                        barrier.await();
                        System.out.println("await");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            try {
                barrier.await();
                System.out.println("await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            barrier.reset();
            if(door) System.exit(0);
            ReorderAndVolatile.reset();
            System.out.println("reset");
        }
    }

    private ReorderAndVolatile(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = new String("value");
    }

    public static ReorderAndVolatile getInstance(){
        if(null==reorderAndVolatile){
            synchronized (ReorderAndVolatile.class){
                if(null==reorderAndVolatile){
                    reorderAndVolatile = new ReorderAndVolatile();
                }
            }
        }
        return reorderAndVolatile;
    }

    public synchronized static void reset(){
        reorderAndVolatile = null;
    }

}
