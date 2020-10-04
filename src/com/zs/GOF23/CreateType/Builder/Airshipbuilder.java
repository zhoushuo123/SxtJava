package com.zs.GOF23.CreateType.Builder;
/**
建造者接口
	 */
public interface Airshipbuilder {
    /**
        构造轨道舱
        */
   Engine CreateEngine();
   /**
    * 构造逃逸塔
       */
   OrbitalModule CreateOrbitalModule();
   /**
       构造发动机
       */
   EscapeTower CreateEscapeTower();

}
