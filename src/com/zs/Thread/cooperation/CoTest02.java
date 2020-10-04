package com.zs.Thread.cooperation;

/**
 * @program: SxtJava
 * @description: 消费者/生产者模式 第二种方法：红绿等标识法
 * @author: 周硕
 * @create: 2020-09-16 12:14
 **/
public class CoTest02 {
    public static void main(String[] args) {
        TV tv= new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}
//生产者 演员
class Player extends Thread{
    TV tv =new TV();

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(i%2==0){
                tv.Paly("奇葩说");
            }
            else {
                tv.Paly("广告太污了，跳过");
            }
        }
    }
}
//消费者 观众
class Watcher extends Thread{
    TV tv =new TV();

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();//没有切换，而是通过信号灯来进行切换，你表演了什么，我就听到了什么
        }
    }
}

//同一个资源 电视 tv
class TV{
    String voice;
    //信号灯
    //T 表示演员表演，观众等待
    //F 表示观众观看，演员等待
    boolean flat = true;

    public synchronized void Paly(String voice){
        //演员等待
        if(!flat){
            try {
                this.wait();
            } catch (InterruptedException e) { }
        }
        //表演
        System.out.println("表演了:"+voice);
        this.voice = voice;
        //唤醒
        this.notify();
        this.flat = !this.flat;
    }
    public synchronized void watch(){
        //观众等待
        if(flat){
            try {
                this.wait();
            } catch (InterruptedException e) { }
        }
        System.out.println("听到了:"+voice);
        //唤醒
        this.notifyAll();
        //切换标志
        this.flat = !this.flat;
    }

}
