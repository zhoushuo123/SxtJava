package com.zs.DynamicCompileTest;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @program: SxtJava
 * @description: 通过反射实现动态编译
 * bytecode
 * @author: 周硕
 * @create: 2020-09-29 17:48
 **/
public class Demo02 {
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "D:/Alltest/helloWorld.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");//0表示编译成功，1表示编译失败

        //使用反射
        try {
            URL[] urls = new URL[]{new URL("file:/" + "D:/Alltest/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("HelloWorld");
            //
            Method m = c.getDeclaredMethod("main",String[].class);
            m.invoke(null,(Object)new String[]{});
//TODO:java.lang.IllegalAccessException: can not access a member of class HelloWorld with modifiers "public static"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

