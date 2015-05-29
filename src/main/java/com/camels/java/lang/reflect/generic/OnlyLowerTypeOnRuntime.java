package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.entity.Entity;
import com.camels.java.lang.reflect.generic.form.Form;

/**
 * @Todo 限制类型为在运行时指定类型的子类
 * Created by zhanggc on 2014/11/3.
 */
public class OnlyLowerTypeOnRuntime <K,V>{

    public static void main(String[] args){
        new OnlyLowerTypeOnRuntime<Entity,Form>().put(new Entity() {
        },new Form() {
        });
    }
    public <Kr extends K,Vr extends V> void put(Kr k,Vr v){}
}
