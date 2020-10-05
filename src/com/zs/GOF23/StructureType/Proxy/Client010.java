package com.zs.GOF23.StructureType.Proxy;

/**
 * @program: SxtJava
 * @description: 010的代理测试
 * @author: 周硕
 * @create: 2020-10-05 09:15
 **/
public class Client010 {
    public static void main(String[] args) {
        Star real = new realStar();
        Star proxy = new Proxy010(real);

        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.cllectMoney();
    }
}
