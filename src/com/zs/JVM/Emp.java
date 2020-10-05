package com.zs.JVM;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import javax.swing.*;

/**
 * @program: SxtJava
 * @description: 测试类
 * @author: 周硕
 * @create: 2020-10-05 11:43
 **/
public class Emp {
    private int empno;
    private String ename;

    public int getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }
}
