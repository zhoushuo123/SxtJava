package com.zs.InterWeb.Tcp.ChatRoom;

import java.io.Closeable;
import java.io.IOException;

/**
 * @program: SxtJava
 * @description: shifangziyun
 * @author: 周硕
 * @create: 2020-09-23 09:04
 **/
public class ZsUtils {
    public static  void close(Closeable... targets){
        for (Closeable target:targets) {
            if(null != target){
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        }
}
