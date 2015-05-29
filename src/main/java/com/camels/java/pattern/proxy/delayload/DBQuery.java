package com.camels.java.pattern.proxy.delayload;

/**
 * @Todo 数据库查询实现
 * Created by zhanggc on 2014/10/22.
 */
public class DBQuery implements IDBQuery {

    public DBQuery(){
        try {
            Thread.sleep(10000);//执行耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //查询
    public Object query(){
        return new Object();
    }
}
