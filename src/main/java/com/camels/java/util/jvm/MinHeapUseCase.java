package com.camels.java.util.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Todo 最少堆使用测试
 * @JAVA_OPTS -Xmx60m -Xms60m -verbose:gc
 * @Tips 当内存实际使用量触及-Xms指定的大小时，会触发Full GC
 * @Optimize -Xms值设置为-Xmx时，系统运行初期减少GC的次数和耗时
 * Created by zhanggc on 2014/11/21.
 */
public class MinHeapUseCase {

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
