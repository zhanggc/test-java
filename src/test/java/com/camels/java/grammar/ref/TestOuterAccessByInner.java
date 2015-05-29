package com.camels.java.grammar.ref;

/**
 *  @Todo 测试 外部类属性通过内部类暴露
 * Created by zhanggc on 2014/10/9.
 */
public class TestOuterAccessByInner {
    public static void main(String[] args){
        new OuterAccessByInner().newInnerClass().println();
    }
}
