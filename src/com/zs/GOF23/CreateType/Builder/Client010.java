package com.zs.GOF23.CreateType.Builder;

/**
 * @program: SxtJava
 * @description: 客户端//消费者
 * @author: 周硕
 * @create: 2020-10-03 17:01
 **/
public class Client010  {
    public static void main(String[] args) {
        Airshipbuilder builder = new Lowbuilder();
        AirshipDiretor diretor = new AirshipDiretorZs(builder);

        AirShip ZsAirship=diretor.diretorAirship();
        System.out.println(ZsAirship.getEngine().getName());
    }
}
