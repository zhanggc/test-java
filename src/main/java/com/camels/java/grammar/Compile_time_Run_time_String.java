package com.camels.java.grammar;

/**
 * @Todo 编译时与运行时 字符串地址值比较
 * Created by zhanggc on 2014/10/30.
 */
public class Compile_time_Run_time_String {

    public static void main(String[] args){
        String compile_time = "value";
        String subfix = "val";
        String run_time = (subfix+"ue");
        System.out.println(compile_time==run_time);
        System.out.println(compile_time==("val"+"ue"));
    }
}
