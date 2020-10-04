package com.zs.GOF23.CreateType.Factory;

/**
 * @program: SxtJava
 * @description: 简单实现工程模式
 * 优点：简单：易用。静态
 * 缺点：不能增加新的类，无法扩展。
 * @author: 周硕
 * @create: 2020-10-03 14:02
 **/
public class factory011 {
    public factory011() {
    }
    public static Car CreateAodi(){ return  new Aodi();}
    public static Car CreateByd(){ return  new Byd();}
}
