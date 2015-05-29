package com.camels.java.pattern.proxy.dynamic.jdk;

import com.camels.java.pattern.proxy.delayload.DBQuery;
import com.camels.java.pattern.proxy.delayload.IDBQuery;

/**
 * @Todo 系统初始化
 * Created by zhanggc on 2014/10/22.
 */
public class System {
    private IDBQuery dbQuery;

    //系统初始化
    public void init(){
        //db 初始化
        dbQuery = (IDBQuery)JdkDBQueryHandler.createProxy(new DBQuery());
        //.....其他初始化
    }

    public IDBQuery newDBQuery(){
        return dbQuery;
    }

    //系统运行
    public static void main(String[] args){
        System system = new System();
        system.init();
        IDBQuery proxy = system.newDBQuery();
        //延迟加载
        proxy.query();
    }
}
