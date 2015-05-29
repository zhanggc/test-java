package com.camels.java.lang.reflect;

import java.lang.reflect.Field;

/**
 * @Todo 反射获取静态属性
 * Created by zhanggc on 2014/11/1.
 */
public class GetStaticAttr {
    private static String value ="static attr";

    public static void main(String[] args)throws Exception{
       Field field = GetStaticAttr.class.getDeclaredField("value");
       String value =  (String)field.get(null);
       System.out.print(value);
    }
}
