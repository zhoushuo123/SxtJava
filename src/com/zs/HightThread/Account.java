package com.zs.HightThread;


import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @program: 马士兵高并发
 * @description: 面试题
 * 模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 行不行（）
 * @author: 周硕
 * @create: 2020-09-13 17:07
 **/
public class Account {
    String name;
    double balance;
    public synchronized void set(String name,double balance){
        this.name = name;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }
    public /*synchronized */ double getBalance(String name){return this.balance;}

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->a.set("张三",100.0)).start();
        System.out.println(a.getBalance("张三"));// balance = 0.0
        //这种数据的读，称为脏读。造成这种问题的原因时 synchronized方法和非syschronized方法时可以同时运行的
        // 解决方法 把非syschronized改为有锁的
        try {
            TimeUnit.SECONDS.sleep(2);//当前线程休息1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("张三"));//balance =100.0


    }
}
