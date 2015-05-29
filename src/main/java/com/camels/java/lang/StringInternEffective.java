package com.camels.java.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * @Todo {@link String#intern()} 重复利用字符串池 减少内存使用(证明错误)
 * Created by zhanggc on 2014/10/29.
 */
public class StringInternEffective {
    private String value;

    public static void main(String[] args){
        String value = null;
        StringInternEffective internEffective = null;
        List<StringInternEffective> internEffectiveList = new ArrayList<StringInternEffective>();
        for(int i=0;i++<10000;){
            value =  new String("重复利用字符串池 减少内存使用");
            internEffective = new StringInternEffective().setValue((value));
            internEffectiveList.add(internEffective);
            value = null;
            internEffective = null;
        }
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        System.out.println("busy: "+(total-free));
    }

    public StringInternEffective setValue(String value) {
        this.value = value;
        return this;
    }
}
