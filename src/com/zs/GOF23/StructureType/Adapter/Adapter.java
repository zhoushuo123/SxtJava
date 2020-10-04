package com.zs.GOF23.StructureType.Adapter;

/**
 * @program: SxtJava
 * @description: 类的（使用继承）适配器
 * 缺点：不灵活
 * @author: 周硕
 * @create: 2020-10-04 11:47
 **/
public class Adapter extends Adaptee implements Taget {
    @Override
    public void handleReq() {
        super.request();
    }
}
