package com.zs.Xml;

import javax.xml.parsers.*;

import org.xml.sax.helpers.*;

import org.xml.sax.*;

import java.io.*;
/**
 * @program: SxtJava
 * @description: 解析xml的正确步骤
 * @author: 周硕
 * @create: 2020-09-26 09:31
 **/


public class  Xmltest02{

    public static void main(String args[]){

        try{

            SAXParserFactory factory=SAXParserFactory.newInstance();

            SAXParser saxParser=factory.newSAXParser();//创建SAX解析器

            Handler handler=new Handler();//创建事件处理器

            saxParser.parse(new File("src/com/zs/Xml/p"),handler);//绑定文件和事件处理者

            System.out.println("该XML文件共有"+handler.count+"标记");

        }

        catch(Exception e)

        {System.out.println(e); }

    }

}

class Handler extends DefaultHandler{

    int count=0;

    public void startDocument(){//解析到文档开始时调用该方法

        System.out.println("开始解析XML文件");

        count++;

    }

    public void endDocument(){//解析到文档结束时调用该方法

        System.out.println("解析文件结束");

        count++;

    }

    public void startElement(String uri,String localName,String qName,Attributes atts){ //解析到标记开始时调用该方法

        System.out.println("<"+qName+">");

        count++;

    }

    public void endElement(String uri,String localName,String qName){//解析到标记结束时调用该方法

        System.out.println("<"+qName+">");

        count++;

    }

    public void characters(char[] ch,int start,int length){//解析到标记间的数据时调用该方法

        String text=new String(ch,start,length);

        System.out.println(text);

        count++;

    }

}