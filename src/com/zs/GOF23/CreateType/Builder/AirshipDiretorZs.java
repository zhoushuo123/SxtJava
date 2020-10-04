package com.zs.GOF23.CreateType.Builder;

/**
 * @program: SxtJava
 * @description: Zs装配者
 * @author: 周硕
 * @create: 2020-10-03 16:49
 **/
public class AirshipDiretorZs implements AirshipDiretor{
    //需要建造者
    Airshipbuilder airshipbuilder;

    public AirshipDiretorZs(Airshipbuilder airshipbuilder) {
        this.airshipbuilder = airshipbuilder;
    }

    @Override
    public AirShip diretorAirship() {
        EscapeTower  es = airshipbuilder.CreateEscapeTower(); //获得发动机
        OrbitalModule or = airshipbuilder.CreateOrbitalModule();//获得轨道舱
        Engine  en = airshipbuilder.CreateEngine();//获得逃逸塔

        //Zs装配
        AirShip airShip = new AirShip();
        airShip.setEngine(en);
        airShip.setEscapeTower(es);
        airShip.setOrbitalModule(or);

        return airShip;
    }
}

