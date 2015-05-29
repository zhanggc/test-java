package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.entity.BaseEntity;
import com.camels.java.lang.reflect.generic.entity.Entity;
import com.camels.java.lang.reflect.generic.entity.TextEntity;
import com.camels.java.lang.reflect.generic.form.Form;

import java.util.ArrayList;
import java.util.List;

/**
 * @Todo {@link java.lang.reflect.WildcardType} 使用
 * Created by zhanggc on 2014/11/2.
 */
public class WildCardTypeUseCase {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    }

    private static class EntityForm implements Entity,Form{}

    private static class WildCardTypeUseCaseClass<T extends Entity & Form>{

        //泛型实例化，通过传递泛型Class
        public static List findList(Class<? extends Entity> tClass) throws IllegalAccessException, InstantiationException {
            List list = new ArrayList();
            for(int i=0;i++<5;){
                list.add(tClass.newInstance());
            }
            return list;
        }

        //? extends var,var 可以为任意类型
        public static WildCardTypeUseCaseClass<? extends Number> create(){
            return new WildCardTypeUseCaseClass();
        }

        //? super var,var 必须继承var..(T extends var..)
       /* public static WildCardTypeUseCaseClass<? super EntityForm> create1(){
            return new WildCardTypeUseCaseClass();
        }*/
    }
}
