package com.camels.java.grammar;

import com.camels.java.lang.reflect.generic.entity.BaseEntity;
import com.camels.java.lang.reflect.generic.entity.Entity;
import com.camels.java.lang.reflect.generic.entity.TextEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Todo 对象数组父、子类之间转换
 * Tips 子类可以向父类转换，父类不能向子类转换
 * Created by zhanggc on 2014/11/3.
 */
public class ArrayExtendsTransform {

    public static void main(String[] args){
    }

    //父类数组存储子类
    public static void parentLoadChild(){
        Entity[] entities = new Entity[1];
        entities[0] = new BaseEntity();
        BaseEntity baseEntity = (BaseEntity)entities[0];
    }

    //父类数组存储子类
    public static void parentLoadChild1(){
        Entity[] entities = new BaseEntity[1];
        entities[0] = new BaseEntity();
        BaseEntity baseEntity = (BaseEntity)entities[0];
    }

    //子类数组存储父类（Error）
    public static void parentLoadChild2(){
        Entity[] entities = new TextEntity[1];
        entities[0] = new BaseEntity();
        BaseEntity baseEntity = (BaseEntity)entities[0];
    }
}
