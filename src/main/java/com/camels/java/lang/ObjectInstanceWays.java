package com.camels.java.lang;

import com.camels.java.util.concurrent.unsafe.NewUnSafe;
import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @Todo 对象实例化方式
 * Created by zhanggc on 2014/10/21.
 */
public class ObjectInstanceWays implements Serializable{

    /**
     * @Tips 只能实例化无参数构造函数
     * @return
     * @throws Exception
     */
    public static ObjectInstanceWays newInstanceWithForName() throws Exception{
        ObjectInstanceWays instance =  (ObjectInstanceWays)Class.forName("com.camels.java.lang.ObjectInstanceWays").newInstance();
        return instance;
    }

    /**
     * @Tips 只能实例化无参数构造函数
     * @return
     * @throws Exception
     */
    public static ObjectInstanceWays newInstance() throws Exception{
        ObjectInstanceWays instance =  ObjectInstanceWays.class.newInstance();
        return instance;
    }

    public static ObjectInstanceWays newObject(){
        ObjectInstanceWays instance = new ObjectInstanceWays();
        return instance;
    }

    /**
     * @Todo 反射
     * @Tips 能实例化带参数构造函数
     * @return
     * @throws Exception
     */
    public static ObjectInstanceWays invokeConstructor() throws Exception{
        Constructor<ObjectInstanceWays> constructor = ObjectInstanceWays.class.getDeclaredConstructor();
        ObjectInstanceWays instance = constructor.newInstance();
        return instance;
    }

    /**
     * @Todo 反序列化
     * @Tips 能实例化带参数构造函数
     * @return
     * @throws Exception
     */
    public static ObjectInstanceWays deserialize() throws Exception{
        ObjectInstanceWays instance = newObject();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        ObjectInstanceWays dInstance = (ObjectInstanceWays)ois.readObject();
        return dInstance;
    }

    /**
     * @Todo {@link sun.misc.Unsafe#allocateInstance(Class)} 实例化
     * @Tips 默认构造函数带参数 throws {@link java.lang.InstantiationException}
     * @return
     * @throws Exception
     */
    public static ObjectInstanceWays allocateInstance() throws InstantiationException, NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = NewUnSafe.getUnsafe();
        ObjectInstanceWays instance = (ObjectInstanceWays)unsafe.allocateInstance(ObjectInstanceWays.class);
        return instance;
    }

    public static void main(String[] args){
        try {
            allocateInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
