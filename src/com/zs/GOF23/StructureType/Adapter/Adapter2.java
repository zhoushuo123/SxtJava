package com.zs.GOF23.StructureType.Adapter;

/**
 * @program: SxtJava
 * @description: 类的（使用继承）适配器
 * 缺点：不灵活
 * @author: 周硕
 * @create: 2020-10-04 11:47
 **/
public class Adapter2  implements Taget {
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}
