package com.camels.java.grammar;

import java.util.ArrayList;

/**
 * @Todo 泛型数组使用
 * @Tips {@code new} 后面禁止使用泛型
 * Created by zhanggc on 2014/11/2.
 */
public class GenericArray {
    private static ArrayList<String>[] arrayList;

    public static void create(){
        arrayList = new ArrayList[1];
        arrayList[0] = new ArrayList<String>();
    }
}
