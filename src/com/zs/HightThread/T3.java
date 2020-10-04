package com.zs.HightThread;

import java.util.concurrent.TimeUnit;

/**
 * @program: 马士兵高并发
 * @description:
 * 一个同步方法可以调用另一个同步方法，一个线程可以拥有每一个对象的锁，再次申请时
 * 仍会得到对象的锁
 * 也就是说syschronized获得的锁是可以重入的
 *
 * syschronized
 * 
 * @author: 周硕
 * @create: 2020-09-13 17:27
 **/
public class T3 {
    public synchronized void t1(){
        System.out.println("t1 start...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2();//同步方法调用同步方法
        System.out.println("t1 end...");
    }
    public synchronized void t2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t2 ");
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        new Thread(t3::t1).start();
        new Thread(t3::t2).start();
    }
}
