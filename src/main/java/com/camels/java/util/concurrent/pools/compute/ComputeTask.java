package com.camels.java.util.concurrent.pools.compute;

import com.camels.java.util.concurrent.pools.io.IOService;

/**
 * @Todo 计算型任务
 * Created by zhanggc on 2015/1/26.
 */
public class ComputeTask implements Runnable{
    private ComputeService service = null;
    public  ComputeTask(ComputeService service){
        this.service = service;
    }

    @Override
    public void run() {
        this.service.service(null);
    }
}
