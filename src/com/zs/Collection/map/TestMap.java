package com.zs.Collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: SxtJava
 * @description: 分析Map容器中的继承体系，测试HashMap，TreeMap的实现类的一些方法
 * @author: 周硕
 * @create: 2020-08-09 20:35
 **/
public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<Integer, String>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();

        m1.put(56, "one");
        m1.put(69, "two");
        m1.put(99, "three");
        m2.put(42, "一");
        m2.put(17, "二");
        System.out.println(m1.size());
        System.out.println(m1.containsKey(1));
        System.out.println(m2.containsValue("two"));
        m1.put(3, "third"); //键重复了，则会替换旧的键值对
        Map<Integer, String> m3 = new HashMap<Integer, String>();
        m3.putAll(m1);
        m3.putAll(m2);
        System.out.println("m1:" + m1);
        System.out.println("m2:" + m2);
        System.out.println("m3:" + m3);
    }
}
