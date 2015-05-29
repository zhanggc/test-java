package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.entity.BaseEntity;
import com.camels.java.lang.reflect.generic.entity.Entity;
import com.camels.java.lang.reflect.generic.form.BaseForm;
import com.camels.java.lang.reflect.generic.form.Form;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Todo 多个泛型参数使用
 * Created by zhanggc on 2014/11/2.
 */
public class MultiGenericParams {
    public static  void main(String[] args){
        Class[] classes = getChild3Generic();
        if(classes!=null && classes.length>1){
            System.out.println(classes[0]);
            System.out.println(classes[1]);
        }else
            System.out.println(classes);
    }

    private interface Parent<F extends Form,E extends Entity>{}

    private class Child1 implements Parent{}

    private class Child2 implements Parent<BaseForm,BaseEntity>{}

    private class Child3<F extends BaseForm,E extends BaseEntity> implements Parent<F,E>{}

    //Parent 泛型类型为 TypeVariable
    public static Class[] getParentGeneric(){
        Class[] classes = new Class[2];
        Type[] types = Parent.class.getTypeParameters();
        if(types.length>1 && types[0] instanceof TypeVariable && types[1] instanceof TypeVariable){
            Type[] _types;
            _types = ((TypeVariable)types[0]).getBounds();
            classes[0] = (Class)_types[0];
            _types = ((TypeVariable)types[1]).getBounds();
            classes[1] = (Class)_types[0];
            return classes;
        }
        return null;
    }

    //Child1'Parent 泛型类型为 Object' Class
    public static Class[] getChild1ParentGeneric(){
        Type[] types = Child1.class.getGenericInterfaces();
        if(types.length>0 && types[0] instanceof Class){
            return null;
        }
        return null;
    }

    //Child2'Parent 泛型类型为 ParameterizedType
    public static Class[] getChild2ParentGeneric(){
        Class[] classes = new Class[2];
        Type[] types = Child2.class.getGenericInterfaces();
        if(types.length>0 && types[0] instanceof ParameterizedType){
            types = ((ParameterizedType)types[0]).getActualTypeArguments();
            classes[0] = (Class)types[0];
            classes[1] = (Class)types[1];
            return classes;
        }
        return null;
    }

    //Child3'Parent 泛型类型为 TypeVariable
    public static Class[] getChild3ParentGeneric(){
        Class[] classes = new Class[2];
        Type[] types = Child3.class.getGenericInterfaces();
        if(types.length>0 && types[0] instanceof ParameterizedType){
            Type[] _types;
            types = ((ParameterizedType)types[0]).getActualTypeArguments();
            if(types.length>1 && types[0] instanceof TypeVariable&& types[1] instanceof TypeVariable) {
                _types = ((TypeVariable)types[0]).getBounds();
                classes[0] = (Class)_types[0];
                _types = ((TypeVariable)types[1]).getBounds();
                classes[1] = (Class)_types[0];
            }
            return classes;
        }
        return null;
    }

    //Child3 泛型类型为 TypeVariable
    public static Class[] getChild3Generic(){
        Class[] classes = new Class[2];
        Type[] types = Child3.class.getTypeParameters();
        if(types.length>1 && types[0] instanceof TypeVariable && types[1] instanceof TypeVariable){
            Type[] _types;
            _types = ((TypeVariable)types[0]).getBounds();
            classes[0] = (Class)_types[0];
            _types = ((TypeVariable)types[1]).getBounds();
            classes[1] = (Class)_types[0];
            return classes;
        }
        return null;
    }
}
