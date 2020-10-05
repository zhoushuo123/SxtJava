package com.zs.JVM;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;

/**
 * @program: SxtJava
 * @description: 自己实现一个文件系统的加载器
 * @author: 周硕
 * @create: 2020-10-05 19:51
 **/
public class FileClassLoader extends ClassLoader{
   private String rootDir;//.class文件在那个包下

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class c = findLoadedClass(name);
        if(c!=null){//如果发现要加载的.class,已经加载过了。直接返回
            return c;
        }else {
           ClassLoader parent= this.getParent(); //找父加载器，使用双亲委派机制

            try {
                c=parent.loadClass(name);//使用双亲委派机制；会一直向上找父类的加载，直到c=null或者找到
            }catch (Exception e){

            }
           if(c!=null){//在父系辈 发现这个要加载的。class加载过了，返回
               return c;
           }else {//.class之前都没被加载过，自己加载
            byte[] ClassData = getClassData(name);//从输入的路径得到.class文件的字节数组
               if(ClassData==null){
                   throw new ClassNotFoundException();
               }else {
                   c = defineClass(name,ClassData,0,ClassData.length);//将得到的。class字节数组文件进行加载
               }
           }
        }
        return c;
    }

   public byte[] getClassData(String classname)  { //得到.class的字节数组的表示
        String classpath = rootDir+"/"+classname.replace('.','/')+".class";
       InputStream is = null;
       ByteArrayOutputStream baos =new ByteArrayOutputStream();
       try {
            is= new FileInputStream(classpath);
            //将输入流转换为字节数组输出到输出流；再将输出流按照字节数组的类型返回
            byte[] datas = new byte[1024];
            int len =0;
            while ((len=is.read(datas))!=-1){
                baos.write(datas,0,len);
            }
            return baos.toByteArray();
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }finally {
           if(is!=null){//关闭输入流
               try {
                   is.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(baos!=null){//关闭输出流
               try {
                   baos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }
}
