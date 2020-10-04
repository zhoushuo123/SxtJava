package com.zs.GOF23.CreateType.Builder;

/**
 * @program: SxtJava
 * @description:Serion建造者
 * @author: 周硕
 * @create: 2020-10-03 16:30
 **/
public class Serionbuilder implements Airshipbuilder {

    @Override
    public Engine CreateEngine() {
        System.out.println("高端轨道舱");
        return new Engine("SerionEngine");
    }

    @Override
    public OrbitalModule CreateOrbitalModule() {
        System.out.println("高端逃逸塔");
        return new OrbitalModule("SerionOrbitalModule");
    }

    @Override
    public EscapeTower CreateEscapeTower() {
        System.out.println("高端发动机");
        return new EscapeTower("SerionEscapeTower");
    }
}
