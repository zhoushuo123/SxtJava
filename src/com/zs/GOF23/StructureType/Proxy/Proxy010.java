package com.zs.GOF23.StructureType.Proxy;
/**
 * @program: SxtJava
 * @description: 静态代理
 * @author: 周硕
 * @create: 2020-10-05 09:15
 **/
public class Proxy010 implements Star{
    Star singStar;

    public Proxy010(Star singStar) {
        this.singStar = singStar;
    }

    @Override
    public void confer() {
        System.out.println("面谈");
    }

    @Override
    public void signContract() {
        System.out.println("签合同");

    }

    @Override
    public void bookTicket() {
        System.out.println("买票");

    }

    @Override
    public void sing() {
        singStar.sing();//唱歌还是的真正的歌手来唱歌
    }

    @Override
    public void cllectMoney() {
        System.out.println("收尾款");

    }
}
