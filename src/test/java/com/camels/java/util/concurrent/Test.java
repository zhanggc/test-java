package com.camels.java.util.concurrent;

/**
 * Created by zhanggc on 2014/9/30.
 */
public class Test {
    private volatile int  vl;
    public void incr(){
        vl++;
    }
    public synchronized void  incrwidthsyn(){
        vl++;
    }
}
