package com.zs.Reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: SxtJava
 * @description: 三种方式实现反射
 *
 * 1获得Class对象
 * 2 可以动态创建
 * @author: 周硕
 * @create: 2020-09-25 09:21
 **/
public class getclz {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //1 对象.getClass()
        User user1 = new User();
        // 通过一个完整的对象获得包名和类名
        String bao_ClassNmae = user1.getClass().getName();
        System.out.println(bao_ClassNmae);//com.zs.Reflection.Iphone
        Class clz = user1.getClass();
        //2 类.Class
        clz = User.class;
        //3 Class.forNmae(包名.类名)
        clz = Class.forName("com.zs.Reflection.User");

        User user2 =(User)clz.getConstructor().newInstance();
        System.out.println(user2);
        System.out.println("----------------------");

        int[] arry01 = new int[10];
        int[][] arry02 =new int[10][20];
        int[] arry03 = new int[30];
        //一个类被加载后，JVM会给类创建一个对应的Class对象（不是实例化对象）
        //类的整个结构信息都会放到这个Class对象中，也就是说Class对象就像一个镜子一样，
        //通过这个Class对象我们可以看到所有的类的信息
        Class myInt =int[].class;
        System.out.println(arry01.getClass().hashCode());//1735600054
        System.out.println(arry02.getClass().hashCode());//1735600054
        System.out.println(arry03.getClass().hashCode());//21685669
        System.out.println(myInt.hashCode());//1735600054
        //因为一个类被加载后，JVM会给类创建就这一个对应的Class对象（不是实例化对象）
        //因此arry01.arry02,arry04 的getClass（）.hashCode()都相等


    }
}
