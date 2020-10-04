package com.zs.GOF23.CreateType.Factory;

/**
 * @program: SxtJava
 * @description: 测试简单的工程模式
 * @author: 周硕
 * @create: 2020-10-03 14:31
 **/
public class Test011 {
    public static void main(String[] args) {
        Car car1 = factory011.CreateAodi();
        Car car2 = factory011.CreateByd();
        car1.run();
        car2.run();
    }
}
