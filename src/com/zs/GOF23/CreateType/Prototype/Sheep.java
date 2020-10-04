package com.zs.GOF23.CreateType.Prototype;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.Date;

/**
 * @program: SxtJava
 * @description: 拷贝的原对象(浅拷贝)
 * @author: 周硕
 * @create: 2020-10-03 18:01
 **/
public class Sheep implements Cloneable{
    public  void Sheep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        return obj;
    }
}
