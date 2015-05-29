package com.camels.java.grammar.extend;

/**
 * @Todo 内部静态类提供外部使用
 * Created by zhanggc on 2014/10/8.
 */
public class OuterStaticUse {

    //静态内部类
    public static class OuterClass{
        public void println(){
            System.out.println("outer class");
        }
    }
}
