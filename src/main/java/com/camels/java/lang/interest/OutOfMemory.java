package com.camels.java.lang.interest;

import java.util.Date;

/**
 * @Todo 内存溢出java.lang.OutOfMemoryError: Java heap space
 * @Heapdump  -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=c:\heap.hprof
 * Created by zhanggc on 2014/12/17.
 */
public class OutOfMemory {
    String value;
    OutOfMemory(String value){ this.value = value;}

    //occur Out Of Memory
    static void oom(){
        Object[] obj = new Object[10000000];
        OutOfMemory oom;
        for(int i=0;;){
            oom = new OutOfMemory(new Date().toString());
            obj[i++] = oom;
        }
    }


    public static void main(String[] args){
        oom();
    }



}
