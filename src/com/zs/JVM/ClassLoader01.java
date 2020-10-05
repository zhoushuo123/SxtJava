package com.zs.JVM;

/**
 * @program: SxtJava
 * @description: 类加载器的事情
 * @author: 周硕
 * @create: 2020-10-05 18:03
 **/
public class ClassLoader01 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        ClassLoader parent = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
    }

}
