package com.zs.WebServer.servlet;

/**
 * @program: SxtJava
 * @description: 通过解析xml文件拿到要反射的类路径
 *
 * <servlet>
 *    <servlet-name>login</servlet-name>
 *    <servlet-class>com.shsxt.LoginServlet</servlet-class>
 * </servlet>
 * @author: 周硕
 * @create: 2020-09-26 10:01
 **/
public class Entity{
    private String name;
    private String clz;

    public Entity() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public String getClz() {
        return clz;
    }

}
