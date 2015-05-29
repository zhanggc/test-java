package com.camels.java.lang.interest;

import java.lang.reflect.Field;

/**
 * @Todo {@code final} 修饰变量 可以使用 反射修改
 * @Tips Since final field are replaced at compile time with the compile-time constant,So changed value unaffected
 * Created by zhanggc on 2014/10/16.
 */
public class ReflectChangeFinal {
    //Since final field are replaced at compile time with the compile-time constant,So changed value unaffected
//    final String value = "orginal";
    final String value;

    ReflectChangeFinal(String value){
        this.value = value;
    }

    public static void reflectChange(ReflectChangeFinal changeFinal) throws NoSuchFieldException, IllegalAccessException {
        Field field = ReflectChangeFinal.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(changeFinal,"changed");
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ReflectChangeFinal changeFinal = new ReflectChangeFinal("orginal");
        System.out.println(changeFinal.value);
        reflectChange(changeFinal);
        System.out.println(changeFinal.value);
    }
}
