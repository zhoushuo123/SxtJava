package com.zs.JVM;

import javassist.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: SxtJava
 * @description: 测试javassist的API
 * @author: 周硕
 * @create: 2020-10-05 12:23
 **/
public class JavassistTest {
    /**
     * 处理类的基本用法
     */
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();//类池
        CtClass cc =pool.get("com.zs.JVM.Emp"); ///获得已有的类

        byte[]  bytes = cc.toBytecode();//获得类的字节数组
        System.out.println(Arrays.toString(bytes));
        /**
         * getname //获得类名
         * getSuperclass //获得父类
         * getInterface //获得接口
         */
    }
    public static  void  test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();//类池
        CtClass cc =pool.get("com.zs.JVM.Emp"); ///获得已有的类

        /**
         * 占位符
         * $0 在javassit种代表 this
         * 
         */

        CtMethod m1 =new CtMethod(CtClass.intType,/*方法返回类型*/"add",/*方法名*/
                new CtClass[]{CtClass.intType,CtClass.intType}/*方法参数类型*/,cc);
        m1.setBody("{return a+b;}");
        cc.addMethod(m1);

        //通过反射调用新生成的方法
        Class clz = cc.getClass();
        Object obj = clz.newInstance();//通过调用无参的构造器获得对象
        Method method = clz.getDeclaredMethod("add",new Class[]{int.class,int.class});
         method.invoke(obj,1,3);
    }

}
