package com.zs.Collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SxtJava
 * @description: 重写equals方法
 * 为什么重写 `equals` 时必须重写 `hashCode` 方法？
 * 如果两个对象相等，则 hashcode 一定也是相同的。两个对象相等,对两个对象分别调用 equals 方法都返回 true。
 * 但是，两个对象有相同的 hashcode 值，的实例的“值”不一定是相等的 。因此，equals 方法被覆盖过，则 `hashCode` 方法也必须被覆盖。
 * @author: 周硕
 * @create: 2020-09-21 16:42
 **/

public class Myequals {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public Myequals(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Myequals that = (Myequals) o;

        if (areaCode != that.areaCode) return false;
        if (prefix != that.prefix) return false;
        return lineNumber == that.lineNumber;
    }

    @Override
    public int hashCode() {
        int result = areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    public static void main(String[] args){
        Map<Myequals,String> phoneNumberStringMap = new HashMap<Myequals,String>(); // 1）初始化
        phoneNumberStringMap.put(new Myequals(123, 456, 7890), "honghailiang");     //    2）put存储
        System.out.println(phoneNumberStringMap.get(new Myequals(123, 456, 7890)));   //  3）get获取

    }
}