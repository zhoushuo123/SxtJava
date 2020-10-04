package com.zs.IO.testUse;

import java.io.*;

/**
 * @program: SxtJava
 * @description: 利用字符流实现拷贝
 * @author: 周硕
 * @create: 2020-08-12 17:18
 **/
public class copyFile02{  /**
 * 1.创建源
 * 2选择流
 * 3操作
 * 4释放资源
 */
public static void main(String[] args) {
    String inputPath = "D:/java学习/SxtJava/src/com/zs/IO/testUse/总体介绍（General introduction）.txt";
    String outputPath = "D:/java学习/SxtJava/src/com/zs/IO/io.txt";
    Copytest(inputPath,outputPath);
}

        public static void Copytest(String Input, String Output) {
            //创建输入源，输出源
            File Inputsrc = new File(Input);
            File Outputsrc = new File(Output);
            //选择流
            FileReader in = null;
            FileWriter out = null;
            //操作
            try {
               in = new FileReader(Inputsrc);
               out = new FileWriter(Outputsrc);
               char[] datas = new char[20];
               int len =-1;
                while( (len = in.read(datas)) != -1){
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
