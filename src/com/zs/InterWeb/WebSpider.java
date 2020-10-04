package com.zs.InterWeb;

import com.sun.org.apache.xerces.internal.util.URI;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

/**
 * @program: SxtJava
 * @description: 简单的网络爬虫  模拟浏览器
 * @author: 周硕
 * @create: 2020-09-17 21:00
 **/
public class WebSpider {
    public static void main(String[] args) throws IOException {
        //
        String Weburl = "https://www.jd.com";
        String Output = "D:/java学习/SxtJava/src/com/zs/InterWeb/jd_html.txt";
        WebSpider wb = new WebSpider();
        wb.WebhtmlGet(Weburl,Output);
    }

    public void WebhtmlGet(String Weburl, String Output) throws IOException {
        //获取Url
        URL url = new URL(Weburl);
        //打开连接
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        //请求方式
        conn.setRequestMethod("GET");
        //模拟浏览器
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
        //打开读入流
        //写入流
        OutputStream out = new FileOutputStream(new File(Output));
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
        String msg = null;
        while (null != ( msg = br.readLine() )) {
            wr.write(msg);
        }
        br.close();
        wr.close();
    }
}
