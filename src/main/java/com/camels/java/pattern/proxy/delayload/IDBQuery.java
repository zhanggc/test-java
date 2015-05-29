package com.camels.java.pattern.proxy.delayload;

/**
 * @Todo 数据库查询接口
 * Created by zhanggc on 2014/10/22.
 */
public interface IDBQuery<T> {
    T query();
}
