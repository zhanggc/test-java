package com.camels.java.util.collection.map;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @Todo 对象作为Map 的key时，需重写{@link #hashCode()},{@link #equals(Object)}
 * Created by zhanggc on 2014/11/8.
 */
public class MapAsDomainUseCase {

    public static void main(String[] args){
        Map<User,String> userStringMap = new HashMap<User, String>();
        User user1 = new User(89);
        User user2 = new User(89);
        userStringMap.put(user1,"89");
        userStringMap.put(user2,"89");
        Assert.assertEquals(1,userStringMap.size());
    }

    private static class User{
        private int id;
        User(int id){
            this.id = id;
        };

        @Override
        public int hashCode() {
            return Integer.valueOf(id).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof User)
                return Integer.valueOf(id).equals(((User)obj).id);
            return false;
        }
    }

}
