package com.zs.IO.testUse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @program: SxtJava
 * @description: 实现文件夹的遍历, 使用递归的方式。并且添加过滤器
 * @author: 周硕
 * @create: 2020-08-12 10:25
 **/
public class traverseFiles {
    /**
     * 需求：使用IO技术，获取磁盘指定目录下的指定类别的文件。说出其中的问题，借助集合改善项目
     * 分析：
     *  1、获取目录下的文件，目录不确定，需要使用程序的人指定（需要键盘录入）
     *  2、文件类别也是不确定的，也是需要指定（需要键盘录入）
     *
     *  Java中的键盘录入，需要使用到Scanner类
     *
     */
    public static void main(String[] args) throws IOException {
        // 创建用于获取键盘录入的流对象
        Scanner scanner = new Scanner( System.in );
        System.out.println("请输入文件所在的目录：");
        String dir = scanner.nextLine();
        System.out.println("请输入查询文件类别：");
        String extName = scanner.nextLine();
        System.out.println(dir);
        System.out.println(extName);
        getFiles(dir , extName);
    }

    /**
     * 用于获取指定目录下的文件
     * @param dir
     * @param extName
     */
    private static void getFiles(String dir, String extName) throws IOException {
        // 把目录封装成一个File对象
        File dirs = new File(dir);
        // 判断目录是否存在
        if( ! dirs.exists() ){
            System.out.println("您输入的目录不存在");
            return ;
        }
        // 获取目录下的文件
        File[] files = dirs.listFiles( new MyFileFilter( extName ) );
        // 判断有没有获取到指定目录下的内容（文件和文件夹）
        if( files == null ){
            System.out.println("您指定的目录下面没有文件，或者是没有权限访问");
            return ;
        }
        // 遍历打印，查阅拿到的数据
        for (File file : files) {
            // 遍历获取到目录下的文件或文件夹
            if( file.isFile() ){
                // 当前拿到的是文件
                System.out.println(file);
            }else{
                // 说明是文件夹
                // 如果是目录（文件夹），可以继续获取这个文件夹中的内容
                getFiles(file.getCanonicalPath() , extName);
            }
        }
    }
}