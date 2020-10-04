package com.zs.Thread.state;

/**
 * @program: SxtJava
 * @description: 优先级
 * 线程的优先级1-10
 * 1.NORM_PRIORITY 5 默认
 * 2.MIN_PRIORITY 1
 * 3.MAX_PRIORIYY 10
 * 优先级高的不代表先后顺序，只代表概率，即获得的时间片多，概率大，容易先运行
 * @author: 周硕
 * @create: 2020-09-14 16:10
 **/
public class priorityThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp,"t1");
        Thread t2 = new Thread(mp,"t2");
        Thread t3 = new Thread(mp,"t3");
        Thread t4= new Thread(mp,"t4");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        Thread.yield();
    }

}