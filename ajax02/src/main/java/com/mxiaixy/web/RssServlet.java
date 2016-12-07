package com.mxiaixy.web;

import com.mxiaixy.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mxia on 2016/12/6.
 */
@WebServlet("/rss.xml")
public class RssServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "http://www.pingwest.com/feed/";
        //传入url 获取响应之后转成的字符串
        String result = HttpUtil.sendHttpGetRequest(url);
        //设置请求和响应的字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //输出xml
        PrintWriter out = resp.getWriter();
        out.write(result);
        out.flush();
        out.close();
        //在jsp中接收



    }
}
