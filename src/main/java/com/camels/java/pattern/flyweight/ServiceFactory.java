package com.camels.java.pattern.flyweight;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Todo 服务工厂
 * Created by zhanggc on 2014/10/23.
 */
public class ServiceFactory {
    private static Map<Class,IService> services = new ConcurrentHashMap<Class,IService>();

    private ServiceFactory(){}

    private static interface Holder{
         ServiceFactory serviceFactory = new ServiceFactory();
    }

    public static ServiceFactory newFactory(){
        return Holder.serviceFactory;
    }

    public IService getService(Class classz){
        if(null==services.get(classz)){
            //..implement for furture
        }
        return services.get(classz);
    }

}
