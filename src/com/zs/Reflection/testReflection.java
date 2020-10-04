package com.zs.Reflection;

import java.lang.reflect.*;

/**
 * @program: SxtJava
 * @description: 测试一下Reflection的一些作用
 * 应用API 获得类对象的（方法，属性，构造器等）
 * @author: 周硕
 * @create: 2020-09-28 17:34
 **/
public class testReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        String path = "com.zs.Reflection.User";
        try {
            Class clz = Class.forName(path);
            //获得类名
            String Classname = clz.getName();
            System.out.println(Classname);

            //获得属性信息
            Field[] fields = clz.getFields();//只能获得publid的属性信息
            Field[] fields1 = clz.getDeclaredFields();//获得所有的Field信息
            Field f = clz.getDeclaredField("name");
            for (Field f1 : fields1) {
                System.out.println("属性：" + f1);
            }

            //获得方法
            Method[] methods1 = clz.getMethods();//只能获得publid的属性信息
            Method[] methods = clz.getDeclaredMethods();//获得所有方法

            Method m01 = clz.getDeclaredMethod("setName", String.class);//有参方法
            Method m02 = clz.getDeclaredMethod("getName");//无参方法
            for (Method m : methods) {
                System.out.println("方法：" + m);
            }

            //获得构造器
           Constructor[] constructors = clz.getDeclaredConstructors();//获得所有的构造器
            for (Constructor c : constructors) {
                System.out.println("构造器：" + c);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
