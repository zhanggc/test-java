/**
 * 项目: test-java
 * 包名：com.camels.java.util
 * 文件名: TestArrays
 * 创建时间: 2014/9/30 11:24
 * 支付界科技有限公司版权所有，保留所有权利
 */
package com.camels.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Todo: 测试Arrays
 * 1. 数组转换List
 * 2. 数组复制
 * @Author: Zhanggc
 */
public class TestArrays<T> {
    //最大hash code
    static final int MAXIMUM_HASHCODE;

    //最大hash code
    static final long EMPTY_POSITION;
    static{
        final long TEMP;
        TEMP = (1 << 30);
        MAXIMUM_HASHCODE = (int)((TEMP << 1)-1) ;

        EMPTY_POSITION = TEMP << 1;
    }
    public static void main(String[] args){
        new ConcurrentHashMap();
        TestArrays testArrays = new TestArrays<String>();
        testArrays.toList(new String[]{"a","b"});
    }

    public List<T> toList(T ... array){
        List<T> list = Arrays.asList(array);
        return new ArrayList<T>(list);
    }

    //数组复制
    public T[] copyof(T ... array){
        return Arrays.copyOf(array,array.length);
    }
}
