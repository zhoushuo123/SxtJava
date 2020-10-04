package com.zs.Reflection;

/**
 * @program: SxtJava
 * @description: 反射测试类
 * @author: 周硕
 * @create: 2020-09-28 17:09
 **/
public class User {
    private String name;
    private int age;
    private String password;

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
