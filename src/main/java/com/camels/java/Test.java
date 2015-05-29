package com.camels.java;

import com.camels.java.util.concurrent.LongAdder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhanggc on 2014/10/11.
 */
public class Test {
    static int inc;
    public static void main(String[] args){



/*        String a= "123",b=new String("123"),c=new String("123").intern();
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);*/



        Integer e =128,f=128,g=127,k=127;
        System.out.println(e==f);
        System.out.println(g==k);










    }

    static void inc(){
        inc++;
    }

    public synchronized void inc1(){
        inc++;
    }

}