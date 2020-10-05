package com.zs.JVM;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;

import java.nio.FloatBuffer;

/**
 * @program: SxtJava
 * @description: 测试
 * @author: 周硕
 * @create: 2020-10-05 21:03
 **/
public class TestFileClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        FileClassLoader Loader = new FileClassLoader("D:/Alltest");
        FileClassLoader Loader2 = new FileClassLoader("D:/Alltest");

        Class<?> cc = Loader.loadClass("HelloWorld");
        Class<?> c1 = Loader2.loadClass("HelloWorld");
        Class<?> c2 = Loader2.loadClass("java.lang.String");
        Class<?> c3 = Loader2.loadClass("com.zs.JVM.B");

        System.out.println(cc.hashCode());//1265094477
        System.out.println(c1.hashCode());   // 2125039532
        System.out.println(cc.getClassLoader());//FileClassLoader
        System.out.println(c3.getClassLoader());//AppClassLoader
        System.out.println(c2.getClassLoader());//null
        //JVM中同一个类加载的对象 如果是不同的加载器加载的同一个类，加载得到的对象也是不同的
    }
}
