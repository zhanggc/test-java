package com.camels.java.grammar.permission;

/**
 * @Todo 实例私有属性在内部使用
 * Created by zhanggc on 2014/10/8.
 */
public class PrivateInstanceInnerUse {
    private PrivateInstanceInnerUse instanceInnerUse;
    private String value;

    private void println(String value){
        System.out.println("private method value "+value);
    }

    public void innerUse(){
        instanceInnerUse.println(instanceInnerUse.value);
    }

}
