package com.zs.Thread.others;


import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: SxtJava
 * @description: 任务定时调度
 * Timer类 类似一个闹钟，可以定时时间；可以安排任务一次，也可以安排重复执行
 * TimerTask类  继承Runnable接口 是一个抽象类
 * @author: 周硕
 * @create: 2020-09-16 12:37
 **/
public class TimerTask01 {
    public static void main(String[] args) {
        Timer timer =new Timer();
        //执行安排
        //timer.schedule(new MyTask(),1000);//一秒后执行一次
        /**
         * delay ：任务执行前的延迟(毫秒)。
         * period:连续任务执行之间的ime(毫秒)
         */
        timer.schedule(new MyTask(),10000,200);//一秒后执行，每间隔200毫秒打印一次

    }


}
class MyTask extends TimerTask {

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("hello word!");
        }
        System.out.println("------end------");
    }
}

