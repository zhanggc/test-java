package com.camels.java.util.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Todo 年轻堆使用测试
 * @JAVA_OPTS -Xmx60m -Xms60m -Xmn25m -XX:+PrintGCDetails
 * @Optimize 年轻堆占整个堆1/4 至 1/3
 * -XX:NewSize 设置年轻堆最小值
 * -XX:MaxNewSize 设置年轻堆最大值
 * -Xmn25m 设置年轻堆最小值与最大值都等于25m
 * Created by zhanggc on 2014/11/22.
 */
public class YoungHeapUseCase {
    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        minMemory();
    }

    //测试最小堆，并且观察GC情况
    public static void minMemory(){
        List<byte[]> m = new ArrayList<byte[]>();
        for(int i=0;i<100;i++){
            m.add(new byte[1024*1024]);
            if(m.size()==20){
                m.clear();
            }
        }
    }

}
