package com.camels.java.util.concurrent.synchronizeds;

/**
 * Created by zhanggc on 2014/9/6.
 */
public class Synchronized {

    public static void main(String[] args){
        final Synchronized syn = new Synchronized();
        new Thread(new Runnable() {
            @Override
            public void run() {
                syn.synthis();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                syn.synobject(syn);
            }
        }).start();
    }

    public synchronized  static void  synstatic(){
        for(;;){
            System.out.println("synstatic");
        }
    }
    public synchronized  static void  synstatic1(){
        for(;;){
            System.out.println("synstatic1");
        }
    }

    public synchronized void normal(){
        for(;;){
            System.out.println("normal");
        }
    }
    public synchronized void normal1(){
        for(;;){
            System.out.println("normal1");
        }
    }

    public  void synthis(){
        synchronized (this){
            for(;;){
                System.out.println("synthis");
            }
        }
    }

    public void synobject(Object obj){
        synchronized (obj){
            for(;;){
                System.out.println("synobject");
            }
        }
    }
}
