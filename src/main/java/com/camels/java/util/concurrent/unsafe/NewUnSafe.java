package com.camels.java.util.concurrent.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Todo {@link sun.misc.Unsafe} 实例化
 * Created by zhanggc on 2014/11/1.
 */
public class NewUnSafe {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = getUnsafe1();
        System.out.print(unsafe);
    }

    //Simple
    public static Unsafe getUnsafe1() throws NoSuchFieldException, IllegalAccessException {
        Field uField = Unsafe.class.getDeclaredField("theUnsafe");
        uField.setAccessible(true);
        return (Unsafe) uField.get(null);
    }

    /**
     * Returns a sun.misc.Unsafe.  Suitable for use in a 3rd party package.
     * Replace with a simple call to Unsafe.getUnsafe when integrating
     * into a jdk.
     *
     * @return a sun.misc.Unsafe
     */
    public static sun.misc.Unsafe getUnsafe() {
        try {
            return sun.misc.Unsafe.getUnsafe();
        } catch (SecurityException tryReflectionInstead) {}
        try {
            return java.security.AccessController.doPrivileged
                    (new java.security.PrivilegedExceptionAction<sun.misc.Unsafe>() {
                        public sun.misc.Unsafe run() throws Exception {
                            Class<sun.misc.Unsafe> k = sun.misc.Unsafe.class;
                            for (java.lang.reflect.Field f : k.getDeclaredFields()) {
                                f.setAccessible(true);
                                Object x = f.get(null);
                                if (k.isInstance(x))
                                    return k.cast(x);
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }});
        } catch (java.security.PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics",
                    e.getCause());
        }
    }
}

