package com.camels.java.pattern.proxy.dynamic.jdk;

import com.camels.java.pattern.proxy.delayload.DBQueryProxy;
import com.camels.java.pattern.proxy.delayload.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Todo Handler
 * Created by zhanggc on 2014/10/22.
 */
public class JdkDBQueryHandler implements InvocationHandler{
    private IDBQuery query;

    private JdkDBQueryHandler(IDBQuery query){
        this.query = query;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(query,args);
    }

    //生成代理
    public static Object createProxy(IDBQuery query){
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{IDBQuery.class}, new JdkDBQueryHandler(query));
    }
}
