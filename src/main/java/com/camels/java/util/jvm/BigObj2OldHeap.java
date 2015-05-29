package com.camels.java.util.jvm;

/**
 * @Todo 大对象进老年堆
 * @JAVA_OPTS -Xmx20m -Xms20m -XX:NewRatio=9 -XX:SurvivorRatio=1 -XX:+PrintGCDetails (or -XX:PretenureSizeThreshold=1000000 -XX:+UseSerialGC -XX:+PrintGCDetails)
 * -XX:PretenureSizeThreshold 设置大对象进入老年堆阈值
 *
 * Created by zhanggc on 2014/11/24.
 */
public class BigObj2OldHeap {
    public static void main(String[] args){
        bigObj2OldHeap();

    }

    public static void bigObj2OldHeap(){
        byte[] m = new byte[2*1024*1024];
    }
}
