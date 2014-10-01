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

/**
 * @Todo: 测试Arrays
 * @Author: Zhanggc
 */
public class TestArrays<T> {

    public static void main(String[] args){
        TestArrays testArrays = new TestArrays<String>();
        testArrays.toList(new String[]{"a","b"});
    }

    public List<T> toList(T ... array){
        List<T> list = Arrays.asList(array);
        return new ArrayList<T>(list);
    }
}
