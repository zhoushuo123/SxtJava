package com.zs.Thread.cooperation;

/**
 * @program: SxtJava
 * @description: 生产者/消费者模式     实现方法一  管存法  利用一个缓存区（管存），在缓存区中满通知消费者消费，空通知生产者生产
 * @author: 周硕
 * @create: 2020-09-16 10:03
 **/
public class Cotest01 {
    public static void main(String[] args) {
        buffer buffer = new buffer(10);
        new Producers(buffer).start();
        new consumers(buffer).start();
    }
}

//生产者
class Producers extends Thread {
    buffer buffer = new buffer(100);

    //buffer buffer = new buffer(Pbuns_count);
    public Producers(buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i <= 100; i++) {
            System.out.println("生产--->" + i + "馒头");
            buffer.push(new buns(i));
        }
    }
}

//消费者consumers
class consumers extends Thread {

    buffer buffer = new buffer(100);

    //buffer buffer = new buffer(Pbuns_count);
    public consumers(buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("消费--->" + buffer.pop().id + "馒头");
        }
    }
}

//缓冲区
class buffer {
    int count;//计数器
    final static int MIN_COUNT = 10;
    buns[] buns = new buns[MIN_COUNT]; //存储数据的容器

    public buffer(int size) {
        this.buns = new buns[size];
    }

    //生产
    public synchronized void push(buns bun) {
        //容器满，不能生产 只有等待
        if (count == buns.length) {
            try {
                this.wait();//线程阻塞， 消费者通知生产可以生产
            } catch (InterruptedException e) {
            }
        }
        buns[count] = bun;
        count++;
        this.notifyAll();//存在数据了，可以消费了
    }

    //消费
    public synchronized buns pop() {
        //容器没有馒头，不能消费 只有等待
        if (count == 0) {
            try {
                this.wait();//线程阻塞， 生产者通知消费可以消费
            } catch (InterruptedException e) {
            }
        }
        //存在数据，可以消费
        count--;
        this.notifyAll();//存在空间可以生产了
        return buns[count];
    }
}

//馒头buns
class buns {
    int id;

    public buns(int id) {
        this.id = id;
    }
}