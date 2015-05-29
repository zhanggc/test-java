package com.camels.java.lang;

/**
 * @Todo {@link java.lang.System} 使用
 * 1. 数组复制
 * Created by zhanggc on 2014/10/20.
 */
public class SystemUseCase {
    private String value = "";

    private SystemUseCase(String value){
        this.value = value;
    }

    public static void main(String[] args){
        SystemUseCase[] src = {new SystemUseCase("1"),new SystemUseCase("2")};
        SystemUseCase[] dest = new SystemUseCase[2];
        System.out.println(dest.length);
        arraycopy(src,0,dest,0,2);
        System.out.println(dest.length);
    }

    public static void arraycopy(Object src,  int  srcPos,
                                 Object dest, int destPos,
                                 int length){
        System.arraycopy(src,srcPos,dest,destPos,length);
    }
}
