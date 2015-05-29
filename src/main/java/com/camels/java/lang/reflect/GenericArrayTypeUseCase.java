package com.camels.java.lang.reflect;

import com.camels.java.lang.reflect.generic.entity.BaseEntity;
import com.camels.java.lang.reflect.generic.entity.Entity;
import com.camels.java.lang.reflect.generic.form.Form;

/**
 * Created by zhanggc on 2014/10/24.
 */
public class GenericArrayTypeUseCase {
    public static void main(String[] args){
        Entity[] entities = new Entity[2];
        entities[0] = new EntityForm();
        EntityForm entityForm = (EntityForm)entities[0];
    }

    private static class EntityForm implements Entity,Form{}
    private static class GenericArrayTypeClass{

        public static <T extends Entity>T[] create(Class<T> tClass) throws Exception{
            Object[] ts = new Object[2];
            ts[0] =tClass.newInstance();
            ts[1] =tClass.newInstance();
            return (T[])ts;
        }
    }
}
