package com.zs.Thread.concurrent;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @program: SxtJava
 * @description: 并发容器
 * @author: 周硕
 * @create: 2020-09-15 19:40
 **/
public class SynContainer {
    public static void main(String[] args) {
        CopyOnWriteArrayList<AtomicInteger> list =new CopyOnWriteArrayList<>();
        for(int i=0;i<100;i++){
            new Thread(()->{
                list.add(new AtomicInteger(1));
            }).start();
        }
        System.out.println(list.size());
    }
}