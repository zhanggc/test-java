package com.camels.java.pattern.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @Todo 打破单例模式
 * Created by zhanggc on 2014/10/21.
 */
public class SingletonBroken {

    //反射
    public static GeekSingleton breakByReflect() throws Exception{
        Constructor<GeekSingleton> constructor = GeekSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        GeekSingleton instance = constructor.newInstance();
        return instance;
    }

    //反序列化
    public static GeekSingleton breakByDeserialize() throws Exception{
        GeekSingleton instance = GeekSingleton.getIntance();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        GeekSingleton dInstance = (GeekSingleton)ois.readObject();
        return dInstance;
    }

    public static void main(String[] args) throws Exception{
        breakByReflect();
        breakByDeserialize();
    }
}
