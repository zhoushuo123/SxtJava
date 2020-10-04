package com.zs.DynamicCompileTest;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * @program: SxtJava
 * @description: 动态编译 将一个文件编译 生成.class字节码文件
 * @author: 周硕
 * @create: 2020-09-29 16:53
 **/

public class Demo01 {
    public static void main(String[] args) throws IOException {
        String  str = "public class Hi{public static main(String[] arg){System.out.println('Hi!!');}}";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result=compiler.run(null,null,null,"D:/Alltest/helloWorld.java");
        System.out.println(result==0?"编译成功":"编译失败");//0表示编译成功，1表示编译失败

        //获得编译文件，运行编译文件 ，获得编译文件的执行的结果
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp D:/Alltest  HelloWorld");

        //得到执行结果
        InputStream in = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info=br.readLine())!=null){
            System.out.println(info);
        }
    }
}
