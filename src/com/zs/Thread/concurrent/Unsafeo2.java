package com.zs.Thread.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SxtJava
 * @description: 操作容器  线程不安全，造成数据的丢失
 * 并发
 * 1同一个对象被多的线程同时操作 
 * @author: 周硕
 * @create: 2020-09-14 17:16
 **/
public class Unsafeo2 {
    public static void main(String[] args) {
        contains contains =new contains();
        for(int i=0;i<10000;i++){
            new Thread(contains).start();
        }
        System.out.println(contains.list.size());
    }
}
class   contains implements Runnable{
    
    List<String>  list =new ArrayList<>();

    @Override
    public   void run() {
        synchronized (this){
            list.add("s");}
    }
}
