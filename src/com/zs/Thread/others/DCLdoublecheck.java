package com.zs.Thread.others;

/**
 * @program: SxtJava
 * @description: 双重检验锁实现对象单例（懒汉式）
 * 1.提供一个私有化静态对象
 * 2 构造器私有化
 * 3提供公共的静态方法获得属性
 * @author: 周硕
 * @create: 2020-09-17 12:25
 **/
public class DCLdoublecheck {
    private  static volatile  DCLdoublecheck dcl;
    //构造器私有化
    public DCLdoublecheck( ) {
    }
    //在此处加synchronized有作用
    public  /*synchronized */static DCLdoublecheck getDCLdoublecheck(){
        //判断什么条件下新建一个对象
        synchronized (DCLdoublecheck.class) {
            if (dcl == null) {
                dcl = new DCLdoublecheck();
            }
        }
        return dcl;
    }
}
