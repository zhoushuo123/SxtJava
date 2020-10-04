package com.zs.IO.testUse;

import java.io.File;
import java.io.IOException;

/**
 * @program: SxtJava
 * @description: 创建文件夹或文件和删除文件夹或文件
 * @author: 周硕
 * @create: 2020-08-11 15:37
 **/
public class FileDome01 {
    public static void main(String[] args) throws IOException {
        File src = new File("src/com/zs/IO/io.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);
        File src1 = new File("src/com/zs/IO/4.jpg");
        boolean flag1 = src1.delete();
        System.out.println(flag1);
    }
}
