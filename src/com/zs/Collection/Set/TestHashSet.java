package com.zs.Collection.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: SxtJava
 * @description: 测试HashSet的一些方法
 * @author: 周硕
 * @create: 2020-08-02 18:14
 **/
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        Set<Integer> T = new TreeSet<>();
        s.add("1");
        s.add("65");
        s.add("3");
        System.out.println(s);
        s.add(null);
        System.out.println(s);
        s.add(null);
        System.out.println(s);//Set集合的无序性
        Set<String> s1 = new HashSet<>();
        s1.add("3");
        s1.add("78");
        s.addAll(s1);
        System.out.println(s);//看出Set集合的不可重复性
    }
}
