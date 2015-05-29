package com.camels.java.grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Todo 通过数组逃脱泛型编译时规范
 * Created by zhanggc on 2014/11/3.
 */
public class ArrayEscapeGenericRule {

    public static void main(String[] args){
        escape1();
    }

    public static void escape(){
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        List<String>[] stringList = new ArrayList[]{integerList};
        stringList[0].add("1");
        integerList.add(1);
    }

    public static void escape1(){
        List<Integer> integerList = new ArrayList<Integer>();
        List temp = integerList;
        List<String> stringList = temp;
        stringList.add("1");
        integerList.add(1);
        temp.add(new Object());
    }
}
