package com.zs.GOF23.CreateType.Factory;

/**
 * @program: SxtJava
 * @description: 测试简单的工程模式
 * @author: 周硕
 * @create: 2020-10-03 14:31
 **/
public class Test010 {
    public static void main(String[] args) {
        Car car1 = new factory010().CreateCar("奥迪");
        Car car2 = new factory010().CreateCar("比亚迪");
        car1.run();
        car2.run();
    }
}
