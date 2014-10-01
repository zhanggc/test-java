package com.camels.java.net.http;

import com.camels.java.utils.CommonHttpConnection;
import com.camels.java.utils.CommonHttpConnection;
import com.camels.java.utils.HttpConnectionParameters;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by zhanggc on 2014/9/3.
 */
public class ConnectionClient {

    public static void main(String[] args){
        long start=0,sum=0;
        HttpConnectionParameters parameters = new HttpConnectionParameters("http://192.168.3.21","GET",10000,12000,new HashMap<String,String>());
        try {
            start = System.currentTimeMillis();
            CommonHttpConnection.proccess(parameters, new HashMap<String, String>());
        } catch (IOException e) {
            sum = System.currentTimeMillis()-start;
            System.out.println(sum);
            e.printStackTrace();
        }
    }
}
