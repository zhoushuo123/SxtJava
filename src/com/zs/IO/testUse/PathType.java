package com.zs.IO.testUse;


import java.io.File;

/**
 * @program: SxtJava
 * @description: 分清楚相对路径和绝对路径
 * @author: 周硕
 * @create: 2020-08-11 15:07
 **/
public class PathType {
    /**
        *1，不管是相对路径或者绝对路径。同意使用/斜杆书写，因为它不会出现跨平台时路径因为斜杠的错误
        *2  对于绝对路径应该从盘符开始写起
        *3  对于相对路径，再写相对路径时，第一个字符不能是/。否则会出错
        *
        */
    public static void main(String[] args) {
        //绝对路径
        String path = "D:/java学习/SxtJava/IO/4.jpg" ;
        File src  = new File(path);
        src.delete();
        System.out.println("绝对路径"+src.getAbsolutePath());
        System.out.println("------------------------------");
        //相对路径
        System.out.println("相对于"+System.getProperty("user.dir"));
        File src1 = new File("/IO/4.jpg");
        File src2 = new File("IO/4.jpg");
        System.out.println("加斜杠/相对路径"+src1.getAbsolutePath());
        System.out.println("不加斜杠/相对路径"+src2.getAbsolutePath());

    }
}
