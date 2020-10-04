package com.zs.WebServer.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SxtJava
 * @description: 设计一个类可以通过URL找的类的路径
 * @author: 周硕
 * @create: 2020-09-26 11:16
 **/
public class ContextUntils {
    private List<Entity> entities ;
    private List<MapEntity> mapEntities;
    //key--->servlet-name  value--->servlet-class
    private Map<String,String> entityMap = new HashMap<>();;
    //key-->url-pattern  value--->servlet-name
    private Map<String,String> mappingMap  = new HashMap<>();

    public ContextUntils(List<Entity> entities, List<MapEntity> mapEntities) {
        this.entities = entities;
        this.mapEntities = mapEntities;
        //将entities中的元素根据key-value放入entityMap
        for (Entity e:entities) {
            entityMap.put(e.getName(),e.getClz());
        }
        for (MapEntity me:mapEntities) {
            for (String pattern:me.getPatterns()) {
                mappingMap.put(pattern,me.getName());
            }

        }

    }
    public String getClz(String pattern){
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }
}