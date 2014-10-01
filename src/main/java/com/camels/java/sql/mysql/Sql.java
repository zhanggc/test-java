/**
 * 项目: test-sql
 * 包名：com.camels.sql.mysql
 * 文件名: Sql
 * 创建时间: 2014/9/29 14:51
 * 支付界科技有限公司版权所有，保留所有权利
 */
package com.camels.java.sql.mysql;

/**
 * @Todo: Mysql 用法
 * @Author: Zhanggc
 */
public  class Sql {

    /**
     * @Todo 在字符串str中，查找子字符串subStr 位置
     * @param subStr
     * @param str
     */
    public void Locate(String subStr,String str){
        String LOCATE ="SELECT LOCATE('a','12a4')";
        System.out.println("Run LOCATE Result: 3");
    }


    /**
     * @Todo 如果a 大于 b，则返回 true,否则返回false
     * @param a
     * @param b
     */
    public void If(int a,int b){
        String IF = "SELECT IF(0>1,'true','false')";
        System.out.println("Run IF Result: false");
    }

}
