package com.camels.java.util.concurrent.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Todo 通过 {@link sun.misc.Unsafe} 直接修改变量内存值
 * Tips Since final field are replaced at compile time with the compile-time constant,So changed value unaffected
 * Created by zhanggc on 2014/11/16.
 */
public class ChangeValueByUnsafe {
    private final int ACCESS_ALLOWED;
    {ACCESS_ALLOWED = 0;}

    public static void main (String[] args)throws Exception{
        ChangeValueByUnsafe object = new ChangeValueByUnsafe();
        change(object);
        System.out.println(object.ACCESS_ALLOWED);
    }

    public static void change(ChangeValueByUnsafe object) throws Exception{
        Unsafe unsafe = NewUnSafe.getUnsafe();
        Field field = ChangeValueByUnsafe.class.getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(object
                ,unsafe.objectFieldOffset(field),1);
    }

}
