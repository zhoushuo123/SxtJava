package com.zs.JVM;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zs.Collection.map.test;

/**
 * @program: SxtJava
 * @description: 类加载的测试
 * @author: 周硕
 * @create: 2020-10-05 16:39
 **/
public class ClassLoadingTest {
    static {
        System.out.println("main的静态初始化块");//1
    }

    public static void main(String[] args) {
//        System.out.println("ClassLoadingTest的main方法");//2
//        A a=new A();//3
//        a.test();//4
//        a.demo();//5
//        A a2 = new A();//6  类加载初始化只有一次
        //A b =new B();
        System.out.println(A.MAX);//final 常量 不用通过类 就可以使用
        System.out.println("---------");
       // System.out.println(A.weight);
      //  System.out.println("---------");
        System.out.println(B.weight);// 静态初始化  的步骤
    }

}

class B extends A{
    public B() {
        System.out.println("B初始化");
    }
}

class A extends  AFather implements AInterface{
    public static String weight="100";
    public static final  int MAX =100;

    public A() {
        System.out.println("创建A类");//3.4
        weight ="300";
    }
    public void test(){
        System.out.println("A的test"+"-->"+this.weight);
    }

    @Override
    public void demo() {
        System.out.println("接口的继承default");
    }

    static {
        System.out.println("A的静态初始化块 ");//3.2
    }
}

class AFather{
    public AFather() {
        System.out.println("创建AFather类");//3.3
    }
    public  void test(){
        System.out.println("AFather的test");
    }

    static {
        System.out.println("AFather的静态初始化块 ");//3.1
    }
}

interface AInterface{
    default void test1() {
        System.out.println("A接口的default方法");
    }//隐式的加载了在3.4步之前
    void demo();
}
