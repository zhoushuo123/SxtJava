package com.zs.GOF23.CreateType.Builder;

/**
 * @program: SxtJava
 * @description:Low的建造者
 * @author: 周硕
 * @create: 2020-10-03 16:30
 **/
public class Lowbuilder implements Airshipbuilder {
    @Override
    public Engine CreateEngine() {
        System.out.println("低端轨道舱");
        return new Engine("LowEngine");//获得对象，可以和工厂模式或者单例模式
    }

    @Override
    public OrbitalModule CreateOrbitalModule() {
        System.out.println("低端逃逸塔");
        return new OrbitalModule("LowOrbitalModule");
    }

    @Override
    public EscapeTower CreateEscapeTower() {
        System.out.println("低端发动机");
        return new EscapeTower("LowEscapeTower");
    }
}
