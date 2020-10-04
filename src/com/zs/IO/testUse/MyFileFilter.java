package com.zs.IO.testUse;

import java.io.File;
import java.io.FileFilter;

/**
 * @program: SxtJava
 * @description: 实现文件的过滤器功能 Filter 过滤
 * @author: 周硕
 * @create: 2020-08-12 10:51
 **/
public class MyFileFilter implements FileFilter {
    private String extName;
    public MyFileFilter(String extName){
        this.extName = extName;
    }
    /**
     * 对文件进行过滤，返回true，文件或文件夹会被留下，返回false，文件或文件夹就会过滤掉
     * @param pathname  需要被过滤的文件或文件夹本身
     * @return
     */
    public boolean accept(File pathname) {
        // 要求是文件夹或者是文件名的后缀为.avi(extName),都留下
        return pathname.isDirectory() ||  pathname.isFile() && pathname.getName().endsWith(extName);
    }
}
