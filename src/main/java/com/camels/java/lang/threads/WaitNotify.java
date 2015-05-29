package com.camels.java.lang.threads;

/**
 * @Todo {@linkplain Thread#wait()} 与 {@linkplain Thread#notify()} 使用
 * @tips
 *        1. 调用wait、notify时，必须锁定(synchronized)自身
 * Created by zhanggc on 2014/9/6.
 */
public class WaitNotify {
    public static void main(String[] args){
        final WaitNotify waitNotify = new WaitNotify();
        final Object obj = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.waitOp(obj);
            }
        });
        thread.start();

        try {
            Thread.sleep(2000);
            System.out.println(thread.getState());
            waitNotify.notifyOp(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                System.out.println(Thread.currentThread().getName()+" waitTime over "+(System.currentTimeMillis()-start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void interrupt(){
        Thread.currentThread().interrupt();
    }
}
