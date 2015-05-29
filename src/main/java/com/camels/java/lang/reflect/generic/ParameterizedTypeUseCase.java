package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.form.BaseForm;
import com.camels.java.lang.reflect.generic.form.Form;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Todo {@link java.lang.reflect.ParameterizedType} 使用
 * Created by zhanggc on 2014/11/2.
 */
public class ParameterizedTypeUseCase {

    public static  void main(String[] args){
        System.out.println(getChild3Generic());
    }

    private interface Parent<T extends Form>{}

    private class Child1 implements Parent{}

    private class Child2 implements Parent<BaseForm>{}

    private class Child3<T extends BaseForm> implements Parent<T>{}

    //Parent 泛型类型为 TypeVariable
    public static Class getParentGeneric(){
        Type[] types = Parent.class.getTypeParameters();
        if(types.length>0 && types[0] instanceof TypeVariable){
            Type[] type = ((TypeVariable)types[0]).getBounds();
            return (Class)type[0];
        }
        return null;
    }

    //Child1'Parent 泛型类型为 Object' Class
    public static Class getChild1ParentGeneric(){
        Type type = Child1.class.getGenericSuperclass();
        if(type instanceof Class){
            return (Class)type;
        }
        return null;
    }

    //Child2'Parent 泛型类型为 ParameterizedType
    public static Class getChild2ParentGeneric(){
        Type[] types = Child2.class.getGenericInterfaces();
        if(types.length>0 && types[0] instanceof ParameterizedType){
            types = ((ParameterizedType)types[0]).getActualTypeArguments();
            return (Class)types[0];
        }
        return null;
    }

    //Child3'Parent 泛型类型为 TypeVariable
    public static Class getChild3ParentGeneric(){
        Type[] types = Child3.class.getGenericInterfaces();
        if(types.length>0 && types[0] instanceof ParameterizedType){
            types = ((ParameterizedType)types[0]).getActualTypeArguments();
            if(types.length>0 && types[0] instanceof TypeVariable) {
                types = ((TypeVariable)types[0]).getBounds();
                return (Class) types[0];
            }
        }
        return null;
    }

    //Child3 泛型类型为 TypeVariable
    public static Class getChild3Generic(){
        Type[] types = Child3.class.getTypeParameters();
        if(types.length>0 && types[0] instanceof TypeVariable){
            types = ((TypeVariable)types[0]).getBounds();
            return (Class) types[0];
        }
        return null;
    }
}
