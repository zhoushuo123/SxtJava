package com.zs.Thread.state;

/**
 * @program: SxtJava
 * @description: jion方法
 * 插队线程  join是成员方法 阻塞的一种
 * @author: 周硕
 * @create: 2020-09-14 15:00
 **/
public class joinThread {
    public static void main(String[] args) {
        Thread t= new Thread(()->{
            for(int i =0;i<5;i++){
                System.out.println("t1 阻塞t2.。");
            }
        });
        Thread t2= new Thread(()->{
                System.out.println("t2 start..");
                try {
                    t.join();//t阻塞t2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 end...");
        });
        t2.start();
        t.start();
    }


}
