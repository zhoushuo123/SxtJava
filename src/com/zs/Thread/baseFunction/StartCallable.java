package com.zs.Thread.baseFunction;

import java.util.concurrent.*;

/**
 * @program: SxtJava
 * @description: 方法三 ：实现Callable接口+call方法
 * <p>
 * 问题：
 * 1、Callable接口的实现的优点； 相比较于Runnable，它可以有返回值和抛出异常。它可以处理一些Runnable不支持的用例
 * 2、Callable和Runnable对象之间的转换 ；工具类 Executors.callable（Runnable task）或者Executors.callable（Runnable task，Object resule）。
 * 将Runable的一个对象封装成Callable对象。
 * @author: 周硕
 * @create: 2020-09-09 10:59
 **/
public class StartCallable implements Callable<Integer> {
    private String winner;//胜利者

    @Override
    public Integer call() throws Exception {
        for (int step = 0; step <= 200; step++) {
            //模拟休息
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && step % 10 == 0) {
                Thread.sleep(2);
            }
            System.out.println(Thread.currentThread().getName() + "--->" + step);
            //比赛是否结束
            if (gemeOver(step)) {
                return step;
            }
        }
        return null;
    }

    //判断谁是胜利者
    private boolean gemeOver(int step) {
        if (winner != null) {
            return true;
        } else {
            if (step == 200) {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是--->" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //同一资源
        StartCallable player = new StartCallable();
        //不同代理（线程）  Callable的使用步骤：
        //创建服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> result1 = ser.submit(player);
        Future<Integer> result2 = ser.submit(player);
        //获取结果
        Integer r1 = result1.get();
        Integer r2 = result1.get();
        System.out.println(r2);
        //关闭服务
        ser.shutdownNow();
    }
}