package com.zs.IO.testUse;

import java.io.*;

/**
 * @program: SxtJava
 * @description: 利用字节流的输入输出，实现文件,图片，等等拷贝的拷贝
 * @author: 周硕
 * @create: 2020-08-12 10:24
 **/
public class copyFile {
    /**
     * 1.创建源
     * 2选择流
     * 3操作
     * 4释放资源
     */
    public static void main(String[] args) {
         String inputPath = "2.jpg";
         String outputPath = "23.jpg";
         Copytest(inputPath,outputPath);
    }

    public static void Copytest(String Input, String Output) {
        //创建输入源，输出源
        File Inputsrc = new File(Input);
        File Outputsrc = new File(Output);
        //选择流
        InputStream in = null;
        OutputStream out = null;
        //操作
        try {
            in = new FileInputStream(Inputsrc);
            out = new FileOutputStream(Outputsrc);
            byte[] datas = new byte[1024];
            int len =-1;
            while( (len=in.read(datas))!= -1){
                out.write(datas,0,len);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源 先打开的后关闭
            try {
                if(in !=null) {
                    out.close();
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
