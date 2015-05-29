package com.camels.java.util.jvm;

import javassist.ClassPool;
import javassist.CtClass;

/**
 * @Todo 设置方法区
 * @JAVA_OPTS -XX:PermSize=40m -XX:MaxPermSize=40m -XX:+PrintGCDetails
 * -XX:MaxPermSize 设置方法区最大值
 * -XX:PermSize 设置方法区初始值
 * @Exceptions {@link OutOfMemoryError} PermGen space
 * Created by zhanggc on 2014/11/22.
 */
public class PermGenUseCase {

    public static void main(String[] args) throws Exception{
        permGenGC1();
    }

    //回收常量池
    public static void permGenGC(){
        for(int i= 0;i<Integer.MAX_VALUE;i++){
            String.valueOf(i).intern();
        }
    }

    //PermGenUseCase 类信息回收不了，导致PermGen space
    public static void permGenGC1(){
        int i = 0;
        try {
            for (; i < Integer.MAX_VALUE; i++) {
                //(PermGen+i) define sub class name
                CtClass c = ClassPool.getDefault().makeClass("PermGen" + i);
                c.setSuperclass(ClassPool.getDefault().get("com.camels.java.util.jvm.PermGenUseCase"));
                //Create sub class
                Class clz = c.toClass();
                PermGenUseCase v = (PermGenUseCase) clz.newInstance();
            }
        } catch (Throwable e) {
            System.out.println(i);
            e.printStackTrace();
        }
    }


}
