package com.zs.IO.testUse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: SxtJava
 * @description: 使用集合的方式比遍历文件夹中的经过过滤器筛选的文件
 * @author: 周硕
 * @create: 2020-08-12 11:40
 **/
public class traverseFiles02 {
    /**
     *  借助集合LinkedList，完成多级子目录的文件遍历获取操作
     *  如果在判断的时候，是目录，不要递归，将目录放到集合中，
     *  针对集合按照一定的次序进行，永远给头部放目录，从尾部取目录
     */
    public static void main(String[] args) throws IOException {
        // 创建用于获取键盘录入的流对象
        Scanner scanner = new    Scanner( System.in );
        System.out.println("请输入查询文件类别：");
        String extName = scanner.nextLine();
        // 获取电脑中所有的磁盘
        File[] roots = File.listRoots();
        for (File root : roots) {
            getFiles(root.getCanonicalPath() , extName);
        }
    }

    /**
     * 用于获取指定目录下的文件
     * @param dir
     * @param extName
     */
    private static void getFiles(String dir, String extName) throws IOException {
        // 定义一个集合：用于存储目录
        //ArrayList<File> list = new ArrayList<>();
       LinkedList<File> files = new LinkedList<>();
        // 把目录封装成一个File对象
        File dirs = new File(dir);
        // 判断目录是否存在
        if( ! dirs.exists() ){
            System.out.println("您输入的目录不存在");
            return ;
        }
        if( dirs.isDirectory() ){
            // 将目录放到集合中
            files.addFirst(dirs);
        }else{
            System.out.println("传递的不是一个文件目录");
        }
        // 集合中就已经有文件目录
        while( files.size() > 0){//
            // 循环成立，说明集合中是有文件目录
            // 从集合尾部获取文件目录
            File file = files.removeLast();
            // 获取从集合中得到的这个目录下的文件和文件夹
            File[] listFiles = file.listFiles(
                    pathname -> pathname.isDirectory() || pathname.isFile() && pathname.getName().endsWith(extName) );
            if( listFiles != null ){
                for (File listFile : listFiles) {
                    // 判断从集合中获取到的这个目录下内容是文件，还是文件夹
                    if( listFile.isDirectory() ){
                        // 如果是目录，这时给集合中继续添加
                        files.addFirst(listFile);
                    }else{
                        System.out.println(listFile);
                    }
                }
            }
        }
    }
}

