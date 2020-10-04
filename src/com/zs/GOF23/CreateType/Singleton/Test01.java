package com.zs.GOF23.CreateType.Singleton;


import com.zs.GOF23.CreateType.Singleton.Singleton_Static;
import com.zs.GOF23.CreateType.Singleton.Singleton_lazy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: SxtJava
 * @description: 反射和反序列化造成的一些问题
 *
 * @author: 周硕
 * @create: 2020-09-30 15:20
 **/
public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

     Class<Singleton_lazy> clz = ( Class<Singleton_lazy>)Class.forName("com.zs.GOF23.CreateType.Singleton.Demo010.Singleton_lazy");
        Method m = clz.getDeclaredMethod("Singleton_lazy");
        m.setAccessible(true);
        Singleton_lazy s1 = clz.getDeclaredConstructor().newInstance();
        Singleton_Static s2 = new Singleton_Static();
        System.out.println(s1.getClass().hashCode());
        System.out.println(s2.getClass().hashCode());
    }
}
