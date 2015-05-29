package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.entity.BaseEntity;
import com.camels.java.lang.reflect.generic.entity.Entity;
import com.camels.java.lang.reflect.generic.entity.TextEntity;
import com.camels.java.lang.reflect.generic.form.Form;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Todo 泛型方法使用
 * Created by zhanggc on 2014/11/2.
 */
public class MethodGeneric<T> {

    public static void main(String[] args) throws Exception {
        Class[] classes = getWildcardGenericParameterTypes();
        if(classes!=null){
            for(Class classz:classes)
                System.out.println(classz);
        }else
            System.out.println(classes);
    }
    private static class MethodGenericClass{
        public <T>List<T> findList(Class<T> tClass) throws IllegalAccessException, InstantiationException {
            List<T> list = new ArrayList<T>();
            for(int i=0;i++<5;){
                list.add(tClass.newInstance());
            }
            return list;
        }

    }

    private static class MethodGenericClass1<T extends Entity>{
        public List<T> findList(Class<T> tClass) throws IllegalAccessException, InstantiationException {
            List<T> list = new ArrayList<T>();
            for(int i=0;i++<5;){
                list.add(tClass.newInstance());
            }
            return list;
        }

        //? extends var,var 可以为任意类型
        public static MethodGenericClass1<? extends BaseEntity> create(){
            return new MethodGenericClass1();
        }

        //? super var,var 必须继承var..(T extends var..)
        public static MethodGenericClass1<? super EntityForm> create1(){
            return new MethodGenericClass1();
        }

        //? extends var,var 可以为任意类型
        public static MethodGenericClass1<? extends BaseEntity> create(MethodGenericClass1<? extends BaseEntity> genericClass1){
            return new MethodGenericClass1();
        }

        //? super var,var 必须继承var..(T extends var..)
        public static MethodGenericClass1<? super EntityForm> create1(MethodGenericClass1<? super EntityForm> genericClass1){
            return new MethodGenericClass1();
        }
    }

    private static class EntityForm implements Entity,Form {}


    //获取方法参数泛型
    public static Class<?>[] getGenericParameterTypes() throws Exception{
        Class[] classes = new Class[2];
        Method method = MethodGenericClass1.class.getDeclaredMethod("findList", Class.class);
        Type[] types = ((TypeVariable)((ParameterizedType)method.getGenericParameterTypes()[0]).getActualTypeArguments()[0]).getBounds();
        classes[0] = (Class)types[0];
        return classes;
    }

    //获取参数类型
    public static Class<?>[] getParameterTypes() throws Exception{
        Method method = MethodGenericClass1.class.getDeclaredMethod("findList", Class.class);
        return method.getParameterTypes();
    }

    //获取返回参数泛型
    public static Class<?>[] getGenericReturnType() throws Exception{
        Class[] classes = new Class[2];
        Method method = MethodGenericClass1.class.getDeclaredMethod("findList", Class.class);
        Type[] types = ((TypeVariable)((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0]).getBounds();
        classes[0] = (Class)types[0];
        return classes;
    }

    //获取返回参数类型
    public static Class<?>[] getReturnType() throws Exception{
        Class[] classes = new Class[2];
        Method method = MethodGenericClass1.class.getDeclaredMethod("findList", Class.class);
        classes[0] = method.getReturnType();
        return classes;
    }

    //获取参数{WildcardType}泛型
    public static Class<?>[] getWildcardGenericParameterTypes() throws Exception{
        Class[] classes = new Class[2];
        Method method = MethodGenericClass1.class.getDeclaredMethod("create",MethodGenericClass1.class);
        Type[] types = ((WildcardType)((ParameterizedType)method.getGenericParameterTypes()[0]).getActualTypeArguments()[0]).getUpperBounds();
        classes[0] = (Class)types[0];
        return classes;
    }

    //获取返回参数{WildcardType}泛型
    public static Class<?>[] getWildcardGenericReturnType() throws Exception{
        Class[] classes = new Class[2];
        Method method = MethodGenericClass1.class.getDeclaredMethod("create");
        Type[] types = ((WildcardType)((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0]).getUpperBounds();
        classes[0] = (Class)types[0];
        return classes;
    }
}
