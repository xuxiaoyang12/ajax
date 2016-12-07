package com.mxiaixy.web;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Ajax 代理模式  jsp->(本域)servlet->(外域)servlet->(本域)servlet->jsp
 *
 * 以下完成 jsp->(本域)servlet->(外域)servlet->(本域)servlet
 * 实现了网页数据向servlet发出请求  本域名下servlet 请求 外域名servlet 并得到返回值 (xml/html)
 * Created by Mxia on 2016/12/6.
 */
@WebServlet("/reader.xml")
public class SaveServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //ajax代理模式
            //网络编程    针对ajax引擎请求非本域名下的Servlet
        //创建一个可以发出请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个get请求
        HttpGet httpGet = new HttpGet("http://www.pingwest.com/feed/");
        //发出get请求并接受客户端的响应
        HttpResponse response = httpClient.execute(httpGet);
        //获取（外域下）服务端的状态码
        int  stateCode = response.getStatusLine().getStatusCode();
        if(stateCode == 200){
                //获取响应输入流
            InputStream inputStream = response.getEntity().getContent();
            //将（响应输入流）结果以字符串的形式输出  并且字符编码是utf-8
            String result = IOUtils.toString(inputStream,"UTF-8");

            inputStream.close();

            //结果获取了服务端响应的结果 以字符串输出在控制台上
            //完成了本域名下servlet 请求 外域名servlet 并得到返回值 (xml/html);

            System.out.println(result);

        }else{
            System.out.println("服务器"+stateCode+"异常");
        }
        httpClient.close();

    }
}
