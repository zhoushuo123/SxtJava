package com.zs.Thread.others;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

/**
 * @program: SxtJava
 * @description: 指令重排 发生在数据和数据没有依赖
 * @author: 周硕
 * @create: 2020-09-17 11:23
 **/
/*求和：
    获取指令 next
    1翻译（解码）
    2取值 从寄存器
    3操作
    4写回（同步） 寄存器 写回的速度慢
    cup为了提高性能 进行的指令重排 单线程没事 多线程可能有问题
    指令重排：虚拟机层面：
    硬件层面：
     */
public class HappenBefore {
    private static int a = 0;
    private static boolean falt = false;

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++) {
            a=0;
            falt =false;
            //读取数据
            Thread t1 = new Thread(() -> {
                a = 1;
                falt = true;
            });
            //更改数据
            Thread t2 = new Thread(() -> {
                if (false) {
                    a *= 1;
                    System.out.println(a);
                }
                if (a == 0) {
                    System.out.println("发生指令重排。。。" + a);
                }
            });
            t1.start();
            t2.start();
            //t1.join();//在main线程中先执行t1线程，在执行main
            //t2.join();//在main线程中先执行t2线程，在执行main

        }
    }
}
