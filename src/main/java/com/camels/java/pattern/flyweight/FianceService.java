package com.camels.java.pattern.flyweight;

/**
 * @Todo 金融服务
 * Created by zhanggc on 2014/10/23.
 */
public class FianceService implements IService{
    @Override
    public void service() {
        try {
            //doing service
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
