package com.zs.Thread.state;

/**
 * @program: SxtJava
 * @description: yield 礼让线程。让当前线程暂停 由运行状态跳回就绪状态，让cpu调度器重新调用
 * 和sleep一样都是静态方法，直接写在线程内部类
 * @author: 周硕
 * @create: 2020-09-14 14:43
 **/
public class YieldThread {
    public static void main(String[] args) {
        for(int i=0;i<5;i++) {
            new Thread(new MyYield(), "t1"+i).start();
        }
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"yield start...");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"yield end...");
    }
}