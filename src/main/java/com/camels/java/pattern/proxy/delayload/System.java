package com.camels.java.pattern.proxy.delayload;

/**
 * @Todo 系统初始化
 * Created by zhanggc on 2014/10/22.
 */
public class System {
    private DBQueryProxy dbQuery;

    //系统初始化
    public void init(){
        //db 初始化
        dbQuery = new DBQueryProxy();
        //.....其他初始化
    }

    public DBQueryProxy newDBQuery(){
        return dbQuery;
    }

    //系统运行
    public static void main(String[] args){
        System system = new System();
        system.init();
        DBQueryProxy proxy = system.newDBQuery();
        //延迟加载
        proxy.query();
    }
}
