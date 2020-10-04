package com.zs.GOF23.StructureType.Adapter;

/**
 * @program: SxtJava
 * @description: 客户，A类 使用对象的组合
 * @author: 周硕
 * @create: 2020-10-04 12:07
 **/
public class Client02 {
    public void test1(Taget t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Client02 client = new Client02();
        Adaptee adaptee = new Adaptee();

        Taget adapter = new Adapter2(adaptee);
        client.test1(adapter);
    }
}
