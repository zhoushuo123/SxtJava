package com.zs.GOF23.StructureType.Adapter;

/**
 * @program: SxtJava
 * @description: 客户，A类
 * @author: 周硕
 * @create: 2020-10-04 12:07
 **/
public class Client01 {
    public void test1(Taget t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Client01 client = new Client01();
        Adaptee adaptee = new Adaptee();
        Taget adapter = new Adapter();
        client.test1(adapter);
    }
}
