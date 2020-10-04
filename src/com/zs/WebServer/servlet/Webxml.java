package com.zs.WebServer.servlet;
import jdk.internal.org.objectweb.asm.Handle;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: SxtJava
 * @description: 解析包含Web信息的Xml文件
 * @author: 周硕
 * @create: 2020-09-26 10:20
 **/
public class Webxml {
    public static void main(String[] args) throws Exception {//异常的抛出应该注意，此处其实不应该抛出大异常的
//        SAX解析
        //1 获得解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2从解析工厂获得解析器
        SAXParser saxParser = factory.newSAXParser();//创建SAX解析器
        //3 加载文档Document
        //4 编写处理器
        WebHandler handler = new WebHandler();//创建事件处理器
        File file = new File("D:/javaStudy/SxtJava/src/com/zs/WebServer/servlet/web");
        saxParser.parse(file, handler);//绑定文件和事件处理者
        //使用ContextUtils类 拿到类名路径
        ContextUntils context = new ContextUntils(handler.getEntities(), handler.getMapEntities());
//        //假设输入的是”/login“ 则：/login--->login---->com.zs.WebServer.servlet.LoginServlet
        String ClassName = context.getClz("/reg");//ClassNmae = com.zs.WebServer.servlet.LoginServlet
        //通过灵魂反射，拿到类
        Class clA = Class.forName(ClassName);
        Servelt servelt = (Servelt)clA.getConstructor().newInstance();
        System.out.println(servelt);
        servelt.service();
        //Iphone iphone1 =(Iphone)clz.getConstructor().newInstance();
        //System.out.println(iphone1);
    }
}
    class WebHandler extends DefaultHandler {
        private List<Entity> entities = new ArrayList<>();
        private List<MapEntity> mapEntities = new ArrayList<>();
        private Entity entity;
        private MapEntity mapEntity;
        private String tag;//存储标签
        private boolean ismapping = false;

        public List<Entity> getEntities() {
            return entities;
        }

        public List<MapEntity> getMapEntities() {
            return mapEntities;
        }

        public void startElement(String uri, String localName, String qName, Attributes atts) { //解析到标记开始时调用该方法
            if (null != qName) {
                tag = qName;//存储标签
                if (tag.equals("servlet")) {
                    entity = new Entity();
                    ismapping = false;
                } else if (tag.equals("servlet-mapping")) {
                    mapEntity = new MapEntity();
                    ismapping = true;
                }
            }
        }

        public void characters(char[] ch, int start, int length) {//解析到标记间的数据时调用该方法
            String contens = new String(ch, start, length);
            if (null != tag) {
                if (ismapping) {
                    if (tag.equals("servlet-name")) {
                        mapEntity.setName(contens);
                    } else if (tag.equals("url-pattern")) {
                        mapEntity.addPattern(contens);
                    }
                } else {
                    if (tag.equals("servlet-name")) {
                        entity.setName(contens);
                    } else if (tag.equals("servlet-class")) {
                        entity.setClz(contens);
                    }
                }
            }
        }

        public void endElement(String uri, String localName, String qName) {//解析到标记结束时调用该方法
            if (null != qName) {
                if (qName.equals("servlet-name")) {
                    entities.add(entity);
                } else if (qName.equals("servlet-mapping")) {
                    mapEntities.add(mapEntity);
                }
            }
            tag = null;
        }
    }