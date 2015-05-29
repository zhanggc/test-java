package com.camels.java.util.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Todo 最大堆测试
 * @JJAVA_OPTS -Xmx6m
 * @Exception  heap space
 * Created by zhanggc on 2014/11/21.
 */
public class MaxHeapUseCase {

    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        maxMemory();
    }

    //测试最大堆
    public static void maxMemory(){
        List<byte[]> m = new ArrayList<byte[]>();
        for(int i=0;i<10;i++){
            m.add(new byte[1024*1024]);
            System.out.println(i+1+"M is allocated");
        }
    }

}
