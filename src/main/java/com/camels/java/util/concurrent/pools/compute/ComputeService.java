package com.camels.java.util.concurrent.pools.compute;

/**
 * @Todo 计算型任务
 * Created by zhanggc on 2015/1/26.
 */
public class ComputeService {
    public Object service(Object data){
        long start = System.currentTimeMillis();
        for(;;){
            long end = System.currentTimeMillis()-start;
            if(end>2000) break;
        }
        System.out.println("compute type task finish,time:"+System.currentTimeMillis());
        return null;
    }
}
