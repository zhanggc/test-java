package com.camels.java.lang.reflect.generic;

import com.camels.java.lang.reflect.generic.entity.BaseEntity;
import com.camels.java.lang.reflect.generic.entity.Entity;

/**
 * @Todo 静态泛型方法
 * @Tips 泛型必须定义在方法上
 * Created by zhanggc on 2014/11/3.
 */
public class StaticGenericMethod {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        BaseEntity entity = create(BaseEntity.class);
    }

    public static <T extends Entity> T create(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }
}
