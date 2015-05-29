package com.camels.java.pattern.proxy.delayload;

/**
 * @Todo 数据库查询代理
 * Created by zhanggc on 2014/10/22.
 */
public class DBQueryProxy implements IDBQuery{
    private DBQuery dbQuery;

    @Override
    public synchronized Object query(){
        if(null==dbQuery)   dbQuery = new DBQuery();
        return dbQuery.query();
    }
}
