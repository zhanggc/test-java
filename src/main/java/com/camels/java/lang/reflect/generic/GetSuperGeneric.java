package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.form.BaseForm;
import com.camels.java.lang.reflect.generic.form.Form;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Todo 得到父类泛型
 * Created by zhanggc on 2014/10/22.
 */
public class GetSuperGeneric {

    static class Super<T extends Form>{}

    static class SubBase extends Super<BaseForm>{}



    public static void main(String[] args){
        System.out.println(getSuperGeneric());

    }

    public static Class getSuperGeneric(){
        Type type = SubBase.class.getGenericSuperclass();
        if(type instanceof ParameterizedType){
            Type[] types = ((ParameterizedType)type).getActualTypeArguments();
            if(types.length>0){
                return (Class)types[0];
            }
        }
        return null;
    }
}
