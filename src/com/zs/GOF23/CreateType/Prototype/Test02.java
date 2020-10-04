package com.zs.GOF23.CreateType.Prototype;

import java.util.Date;

/**
 * @program: SxtJava
 * @description: 测试浅拷贝
 * @author: 周硕
 * @create: 2020-10-03 18:05
 **/
public class Test02 {
    public static void main(String[] args)  {
        Date data = new Date(123412341234L);
        DeepSheep s1 = new DeepSheep("母体",data);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());//1

        try {
            DeepSheep s2 = (DeepSheep) s1.clone();
            s2.setName("子体");
            System.out.println(s2.getName());
            System.out.println(s2.getBirthday());
            data.setTime(23423412341L);//改变母体的引用对象的属性
            System.out.println("改变母体的引用对象，母体引用对象的值："+s1.getBirthday());//2引用对象的属性改变

            System.out.println("改变母体的引用对象，子体引用对象的值："+s2.getBirthday());//3 拷贝的子体引用对象的属性也发生改变

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



    }
}
