package com.zs.InterWeb;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: SxtJava
 * @description:
 * @author: 周硕
 * @create: 2020-09-17 19:44
 **/
public class IPlocal {

    public static void main(String[] args) throws UnknownHostException {
        //获得本机的ip
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        //根据域名得到netAddress对象
        address = InetAddress.getByName("www.github.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }

}
