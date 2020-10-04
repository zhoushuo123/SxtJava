package com.zs.GOF23.CreateType.Prototype;

import java.util.Date;

/**
 * @program: SxtJava
 * @description: 拷贝的原对象(浅拷贝)
 * @author: 周硕
 * @create: 2020-10-03 18:01
 **/
public class DeepSheep implements Cloneable{
    private String name;
    private Date birthday;

    public DeepSheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public DeepSheep() {
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();

        //添加如下代码。。将属性也进行克隆 进行深拷贝
        DeepSheep deepSheep = (DeepSheep)obj;
        deepSheep.birthday = (Date)this.birthday.clone();
        return obj;//TODO:如果是 return deepSheep;他和return obj有何不同
    }
}
