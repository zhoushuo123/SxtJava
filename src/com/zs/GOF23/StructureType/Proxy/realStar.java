package com.zs.GOF23.StructureType.Proxy;
/**
 * @program: SxtJava
 * @description: 真正干事sing的（被代理的）
 * @author: 周硕
 * @create: 2020-10-05 09:15
 **/
public class realStar implements Star{

    @Override
    public void confer() {

    }

    @Override
    public void signContract() {

    }

    @Override
    public void bookTicket() {

    }
    @Override
    public void sing() {
        System.out.println("(真正的歌手)唱歌");
    }

    @Override
    public void cllectMoney() {

    }


}
