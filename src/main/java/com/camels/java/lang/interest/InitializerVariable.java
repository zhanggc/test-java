package com.camels.java.lang.interest;

/**
 * @Todo 变量初始化（顺序）
 * @Tips 类代码运行顺序：静态变量初始化 -> 静态代码块初始化;
 * 实例代码运行顺序：实例变量初始化 -> 实例代码块初始化 -> 构造函数初始化
 * Created by zhanggc on 2014/12/2.
 */
public class InitializerVariable {
    InitializerVariable(){
        l = 10;//order-1-3
    }
    {
        l=11;//order-1-2
    }
    int l;//order-1-1
    static int j = 1;//order-1
    static{//order-2
        j = 10;
    }

    //Accesses by methods are not checked in this way
    static int peek() { return j; }
    //static int k = j; Error!
    static int i = peek();

    public static void main(String[] args){
        System.out.println(InitializerVariable.i);
    }
}
