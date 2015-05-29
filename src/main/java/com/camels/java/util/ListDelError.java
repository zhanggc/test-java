package com.camels.java.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Todo 测试 列表修改导致迭代器{@link ArrayList.Itr#expectedModCount} 异常
 * @since {@link ArrayList#modCount} 没有同步 {@link ArrayList.Itr#expectedModCount}
 * Created by zhanggc on 2014/10/9.
 */
public class ListDelError {

    public static void main(String[] args){
        accessDelError();
    }

    public static void accessDelError(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("del error");
        Iterator iterator = list.iterator();
        /*while (iterator.hasNext()){
            Object obj = iterator.next();
            list.remove(obj);
        }*/
        for(String str :list)
            list.remove(str);
        /*for(int i=0;i<list.size();)
            list.remove(0);*/
    }
}
