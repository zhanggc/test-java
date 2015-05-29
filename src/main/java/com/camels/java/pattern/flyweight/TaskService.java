package com.camels.java.pattern.flyweight;

/**
 * @Todo 任务服务
 * Created by zhanggc on 2014/10/23.
 */
public class TaskService implements IService{
    @Override
    public void service() {
        try {
            //doing service
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
