package com.camels.java.util.concurrent.pools.io;

/**
 * @Todo IO服务
 * Created by zhanggc on 2015/1/26.
 */
public class IOService {

    public Object service(Object data){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("io type task finish,time:"+System.currentTimeMillis());
        return null;
    }
}
