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
 *
 * 创建词典
 * Created by Mxia on 2016/12/6.
 */
@WebServlet("/dic")
public class DictionaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  word = req.getParameter("word");
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q="+word;
        //通过代理模式请求外部词典库数据获取结果
        String result = HttpUtil.sendHttpGetRequest(url);

        //设置字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //输出流
        PrintWriter out = resp.getWriter();

        out.write(result);
        //关闭输出流
        out.flush();
        out.close();


    }
}
