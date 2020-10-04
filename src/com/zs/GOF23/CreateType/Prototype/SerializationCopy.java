package com.zs.GOF23.CreateType.Prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: SxtJava
 * @description: 利用序列化实现深拷贝
 * @author: 周硕
 * @create: 2020-10-03 18:01
 **/
public class SerializationCopy implements Cloneable, Serializable {
    private String name;
    private Date birthday;

    public SerializationCopy(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public SerializationCopy() {
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
        return obj;
    }
}
