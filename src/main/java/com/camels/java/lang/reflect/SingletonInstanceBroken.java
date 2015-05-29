package com.camels.java.lang.reflect;

import com.camels.java.pattern.singleton.GeekSingleton;
import com.camels.java.util.concurrent.unsafe.NewUnSafe;
import sun.misc.Unsafe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @Todo 单例模式通过反射实现实例化
 * Created by zhanggc on 2014/10/21.
 */
public class SingletonInstanceBroken {

    public static void main(String[] args){
        try {
            GeekSingleton singleton = instanceByUnSafe();
            System.out.print(singleton.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Todo 反射
     * @Tips 能实例化带参数构造函数
     * @return
     * @throws Exception
     */
    public static GeekSingleton instanceByReflect() throws Exception {
        GeekSingleton singleton;
        Constructor<GeekSingleton> constructor = GeekSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        return singleton =  constructor.newInstance();
    }

    /**
     * @Todo 反序列化
     * @Tips 能实例化带参数构造函数
     * @return
     * @throws Exception
     */
    public static GeekSingleton instanceByDeserialize() throws Exception{
        GeekSingleton instance = GeekSingleton.getIntance();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        GeekSingleton dInstance = (GeekSingleton)ois.readObject();
        return dInstance;
    }

    /**
     * @Todo {@link sun.misc.Unsafe#allocateInstance(Class)} 实例化
     * @Tips 默认构造函数带参数 throws {@link java.lang.InstantiationException}
     * @return
     * @throws Exception
     */
    public static GeekSingleton instanceByUnSafe() throws InstantiationException, NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = NewUnSafe.getUnsafe();
        GeekSingleton instance = (GeekSingleton)unsafe.allocateInstance(GeekSingleton.class);
        return instance;
    }
}
