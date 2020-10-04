package com.zs.GOF23.CreateType.Builder;

/**
 * @program: SxtJava
 * @description:
 * @author: 周硕
 * @create: 2020-10-03 15:30
 **/
public class AirShip {
    private OrbitalModule orbitalModule;
    private Engine engine;
    private EscapeTower escapeTower;

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }
}

//轨道舱
class Engine {
    private String name;//轨道舱

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//发动机
class EscapeTower {
    private String name;//轨道舱

    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//逃逸塔
class OrbitalModule {
    private String name;//轨道舱

    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}