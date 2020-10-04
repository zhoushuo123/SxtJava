package com.zs.WebServer.servlet;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: SxtJava
 * @description: 通过解析xml文件拿到要反射的类路径
 *
 *  <servlet-mapping>
 *         <servlet-name>login</servlet-name>
 *         <url-pattern>/login</url-pattern>
 *         <url-pattern>/g</url-pattern>
 *     </servlet-mapping>
 * @author: 周硕
 * @create: 2020-09-26 10:01
 **/
public class MapEntity {
    private String name;
    private Set<String> patterns;

    public MapEntity() {
        patterns = new HashSet<>();
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //将pattern加入到patterns容器
    public  void addPattern(String pattern){
        this.patterns.add(pattern);
        //patterns.add(pattern);
    }

}
