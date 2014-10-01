package com.camels.java.util.concurrent.volatiles;

import java.util.logging.Logger;

/**
 * Created by zhanggc on 2014/8/10.
 */
public class OrderCorrection {
    private volatile boolean isChanged;
    private volatile int aVar;
    private int[] bVar = new int[0];
    private volatile int count;

    public static void main(String[] args){
       final OrderCorrection orderCorrection =  new OrderCorrection();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        if(orderCorrection.isChanged){
                            orderCorrection.isCorrect();
                        }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        if(!orderCorrection.isChanged){
                            orderCorrection.change();
                        }
                }
            }).start();
    }

    public  void isCorrect(){
        if(aVar!=bVar.length){
            Logger.getAnonymousLogger().info("aVar: "+aVar+",bVar:"+bVar.length);
            System.exit(0);
        }
        isChanged = false;
    }

    /**
     * @if 线程向主内存store操作，必须同时store所有变量
     */
    public  void change(){
        aVar = count;
        bVar = new int[count];
        count++;
        System.out.println(count);
        isChanged  = true;
    }

    public boolean isChanged(){
        return this.isChanged;
    }
}