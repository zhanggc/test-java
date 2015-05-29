package com.camels.java.util.concurrent;

import java.util.Random;

/**
 * @Todo 极具细粒度并发Map
 * Created by zhanggc on 2014/11/16.
 */
public class FinegrainedConcurrentMap {
    static int length = 160;
    static float factor = 0.75f;
    static int cusor = 0;
    static int thesholder = (int)(length*factor);
    static long[] indexs = new long[length];
    public static void main(String[] args){
        Random random = new Random(100);
        Math.random();
        Object obj;
        for(int i=-1;++i<1000;){
            put(random.nextInt(1000),0);
        }
        for(int i=-1;++i<length;){
            System.out.println("index:"+i+",key:"+indexs[i]+";");
        }
    }

    public static void put(int key,int value){
        Integer aim = null;
        for(int i=-1;++i<length;){
            if(indexs[i] == key){
                aim = i;
                System.out.println("exist index:"+i);
            }
        }
        if(null==aim){
            indexs[++cusor] = key;
            if(cusor>=thesholder){
                length*=2;
                thesholder = (int)(length*factor);
                long[] expend = new long[length];
                System.arraycopy(indexs,0,expend,0,cusor+1);
                indexs = expend;
            }
            System.out.println("new index:"+cusor);
        }else{
            //...exist index.
        }


    }
}
