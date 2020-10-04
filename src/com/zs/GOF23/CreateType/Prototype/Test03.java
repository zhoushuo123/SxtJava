package com.zs.GOF23.CreateType.Prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SxtJava
 * @description: new 对象和利用原型模式拷贝对象的效率比较
 * @author: 周硕
 * @create: 2020-10-03 19:04
 **/
public class Test03 {
    static void testNew(int size){
        long start = System.currentTimeMillis();
        for (int i=0;i<size;i++){
            //TODO:new关键字的底层创建原理
            Sheep sheep = new Sheep();
//            List<Sheep> s = new ArrayList<>();
//            s.add(new Sheep());
        }
        long end = System.currentTimeMillis();
        System.out.println("new对象执行完成的时间为："+(end-start));
    }
    static void testClone(int size) throws CloneNotSupportedException {
        Sheep s1 = new Sheep();
        long start = System.currentTimeMillis();
        for (int i=0;i<size;i++){
                Sheep temp = (Sheep)s1.clone();

//                List<Sheep> s = new ArrayList<>();
//                s.add((Sheep) s1.clone());

        }
        long end = System.currentTimeMillis();
        System.out.println("clone对象执行完成的时间为："+(end-start));
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        testNew(10000);
        testClone(10000);
    }
}
