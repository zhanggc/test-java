package com.camels.java.util.concurrent.pools.io;

/**
 * @Todo IO型任务
 * Created by zhanggc on 2015/1/26.
 */
public class IOTask implements Runnable{
    private IOService service = null;
    public  IOTask(IOService service){
        this.service = service;
    }

    @Override
    public void run() {
        service.service(null);
    }
}
