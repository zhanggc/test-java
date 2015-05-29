package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.entity.BaseEntity;
import com.camels.java.lang.reflect.generic.entity.Entity;
import com.camels.java.lang.reflect.generic.form.BaseForm;
import com.camels.java.lang.reflect.generic.form.Form;
import com.camels.java.lang.threads.ClassLockUse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Todo 多个上限泛型使用
 * Created by zhanggc on 2014/11/2.
 */
public class MultiBoundsGeneric {

    public static  void main(String[] args){
        Class[] classes = getChild3Generic();
        if(classes!=null && classes.length>1){
            System.out.println(classes[0]);
            System.out.println(classes[1]);
        }else
            System.out.println(classes);
    }

    private class BaseFormEntity implements Form,Entity{}

    private interface Parent<O extends Form & Entity>{}

    private class Child1 implements Parent{}

    private class Child2 implements Parent<BaseFormEntity>{}

    private class Child3<O extends BaseFormEntity> implements Parent<O>{}


    //Parent 上限泛型
    public static Class[] getParentGeneric(){
        Class[] classes = new Class[2];
        Type[] types = Parent.class.getTypeParameters();
        if(types.length>0&&types[0] instanceof TypeVariable){
            types = ((TypeVariable)types[0]).getBounds();
            if(types.length>1){
                classes[0] = (Class)types[0];
                classes[1] = (Class)types[1];
                return classes;
            }
        }
        return classes;
    }

    //Child1'Parent 上限泛型
    public static Class[] getChild1ParentGeneric(){
        Class[] classes = new Class[2];
        Type[] types = Child1.class.getTypeParameters();
        if(types.length>0 && types[0] instanceof Class){
            return classes;
        }
        return classes;
    }

    //Child2'Parent 上限泛型
    public static  Class[] getChild2ParentGeneric(){
        Class[] classes = new Class[2];
        Type[] types = Child2.class.getGenericInterfaces();
        if(types.length>0 && types[0] instanceof ParameterizedType){
            types = ((ParameterizedType)types[0]).getActualTypeArguments();
            classes[0] = (Class)types[0];
            classes[1] = null;
        }
        return classes;
    }

    //Child3'Parent 上限泛型
    public static Class[] getChild3ParentGeneric(){
        Class[] classes = new Class[2];
        Type[] types = Child3.class.getGenericInterfaces();
        if(types.length>0 && types[0] instanceof ParameterizedType){
            types = ((ParameterizedType)types[0]).getActualTypeArguments();
            if(types.length>0 && types[0] instanceof TypeVariable) {
                types = ((TypeVariable)types[0]).getBounds();
                classes[0] = (Class)types[0];
                classes[1] = null;
            }
        }
        return classes;
    }

    //Child3 上限泛型
    public static Class[] getChild3Generic(){
        Class[] classes = new Class[2];
        Type[] types = Child3.class.getTypeParameters();
        if(types.length>0 && types[0] instanceof TypeVariable){
            types = ((TypeVariable)types[0]).getBounds();
            classes[0] = (Class)types[0];
            classes[1] = null;
        }
        return classes;
    }
}
