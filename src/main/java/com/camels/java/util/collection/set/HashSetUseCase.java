package com.camels.java.util.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Todo {@link java.util.HashSet} 基本方法使用
 * Created by zhanggc on 2014/11/30.
 */
public class HashSetUseCase {
    private static final HashSet<String> set = new HashSet<String>();

    public static void main(String[] args){
        add("12");
        iterator();
        remove("12");
    }

    //set add
    public static boolean add(String element){
        return set.add(element);
    }

    //set remove
    public static boolean remove(String element){
        return set.remove(element);
    }

    //set iterator
    public static void iterator(){
        Iterator<String> iterator = set.iterator();
        for(;iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }

}
