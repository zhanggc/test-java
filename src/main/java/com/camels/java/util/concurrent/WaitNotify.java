package com.camels.java.util.concurrent;

/**
 * Created by zhanggc on 2014/9/6.
 */
public class WaitNotify {
    public static void main(String[] args){
        final WaitNotify waitNotify = new WaitNotify();
        new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.waitTimeOp(waitNotify, 5000);
            }
        }).start();
    }

    public void notifyOp(Object obj){
        synchronized (obj){
            obj.notify();
            System.out.println("notify over");
        }
    }

    public void notifyAllOp(Object obj){
        synchronized (obj){
            obj.notifyAll();
            System.out.println("notifyAll over");
        }
    }

    public void waitOp(Object obj){
        synchronized (obj){
            try {
                obj.wait();
                System.out.println("wait over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void waitTimeOp(Object obj,int time){
        synchronized (obj){
            try {
                long start = System.currentTimeMillis();
                obj.wait(time);
                System.out.println("waitTime over "+(System.currentTimeMillis()-start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
