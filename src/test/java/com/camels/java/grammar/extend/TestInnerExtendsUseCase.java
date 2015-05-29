package com.camels.java.grammar.extend;

/**
 * @Todo 测试内部类继承特例
 * Created by zhanggc on 2014/10/8.
 */
public class TestInnerExtendsUseCase{
    public static void main(String[] args){
        InnerExtendsUse.InnerClass innerClass = new InnerExtendsUseCase().newInnerClass();
        innerClass.println();
    }
}
