package com.zs.GOF23.CreateType.Factory;

/**
 * @program: SxtJava
 * @description: 简单实现工程模式
 * 优点：简单：易用。静态
 * 缺点：不能增加新的类，无法扩展。
 * @author: 周硕
 * @create: 2020-10-03 14:02
 **/
public class factory010 {
    public factory010() {
    }

    public Car CreateCar(String name){
        if("奥迪".equals(name)){
            return new Aodi();
        }else if("比亚迪".equals(name)){
            return new Byd();
        }else
            return null;
    }
}
