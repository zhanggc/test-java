package com.camels.java.pattern.singleton;

import java.io.Serializable;

/**
 * @Todo 极致单例
 * Created by zhanggc on 2014/10/21.
 */
public class GeekSingleton implements Serializable {

    private GeekSingleton(){}

    //Stop deserialize break Singleton
    private Object readResolve(){
        return getIntance();
    }

    //静态内部类持有单例
    private static class SingletonHolder{
        private static final GeekSingleton singleton = new GeekSingleton();
    }

    public static GeekSingleton getIntance(){
        return SingletonHolder.singleton;
    }

    public static void main(String[] args){
        GeekSingleton singleton = GeekSingleton.getIntance();
    }
}
