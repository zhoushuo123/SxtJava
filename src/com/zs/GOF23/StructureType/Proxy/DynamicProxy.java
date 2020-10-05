package com.zs.GOF23.StructureType.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: SxtJava
 * @description: 动态代理
 * @author: 周硕
 * @create: 2020-10-05 10:30
 **/
public class DynamicProxy implements InvocationHandler {
    Star realStar;

    public DynamicProxy(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) //
            throws Throwable {

        method.invoke(realStar,args);
        return null;
    }
}
