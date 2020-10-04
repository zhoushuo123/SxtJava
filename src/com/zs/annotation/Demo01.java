package com.zs.annotation;

import javax.swing.plaf.PanelUI;

/**
 * @program: SxtJava
 * @description: 注解
 * 1什么是注解
 * 就是代码中里的特殊标记，并且这些标记可以在编译、类加载，运行时被读取
 * 他就在某些方面下就像修饰符一样，提供对方法，类，构造器成员变量，参数，局部变量等的一些声明
 * 这些信息被存储在Annotation中“name=value”中
 * 2，注解的作用
 *      1 声明，注解
 *      2在不改变原本的代码逻辑，可以补充信息进行验证或者部署
 *      3利用APT 相应的处理他的配套工具，位程序元素设值元数据
 * 3,JAVA中内置一些常用的注解
 *      1@Override 限定重写父类方法
 *      2@Deprecated  标记已过时
 *      3@SuupressWarnings  抑制编译器警告
 * @author: 周硕
 * @create: 2020-09-27 10:37
 **/
public class Demo01 {
    @Override //说明这个方法是重写父类的方法，并且如果不是，编译器会报错
    public String toString(){
        return "";
    }

    @Deprecated
    public void test001(){
        System.out.println("不建议使用");
    }
    @SuppressWarnings("all")

    public static void main(String[] args) {
       Demo01 deno = new Demo01();
       deno.test001();//
    }
}
