package com.zs.Xml;

import javax.xml.parsers.*;

import org.xml.sax.helpers.*;

import org.xml.sax.*;

import java.io.File;
import java.io.IOException;


/**
 * @program: SxtJava
 * @description: 熟悉Xml解析流程   流式处理
 * Xml 可扩展标记语言  就是标签可以自己定义
 * @author: 周硕
 * @create: 2020-09-25 10:32
 **/
public class XmlTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        SAX解析
        //1 获得解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //2从解析工厂获得解析器
        SAXParser saxParser=factory.newSAXParser();//创建SAX解析器
        //3 加载文档Document
        //4 编写处理器
        MyHandler handler=new MyHandler();//创建事件处理器
        File file = new File("D:/javaStudy/SxtJava/src/com/zs/Xml/person");
        saxParser.parse(file,handler);//绑定文件和事件处理者

    }
}

class MyHandler extends DefaultHandler {
    int i= 5;
    public void startDocument() throws SAXException{//解析到文档开始时调用该方
        System.out.println("开始解析XML文件");
    }
    public void startElement(String uri,String localName,String qName,Attributes atts){ //解析到标记开始时调用该方法

        System.out.println("<"+qName+">");
    }
    public void endElement(String uri,String localName,String qName){//解析到标记结束时调用该方法

        System.out.println("<"+qName+">");
    }
    public void characters(char[] ch,int start,int length){//解析到标记间的数据时调用该方法
        String text=new String(ch,start,length);
        System.out.println(text);

    }

    public void endDocument()throws SAXException{//解析到文档结束时调用该方法
        System.out.println("解析文件结束");
    }

}