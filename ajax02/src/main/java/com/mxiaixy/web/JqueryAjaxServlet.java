package com.mxiaixy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mxia on 2016/12/7.
 */
@WebServlet("/jqueryAjax")
public class JqueryAjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取请求传入值
//        String name = req.getParameter("name");
//        System.out.println(name);
//        //设置字符编码
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//
//
//        PrintWriter out = resp.getWriter();
//        //判断输入文本是否可用
//        if("tom".equals(name)){
//            out.write("不可用");
//        }else{
//            out.write("可用");
//        }
//        //关闭输出流
//        out.flush();
//        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求传入值
        String name = req.getParameter("name");
        System.out.println(name);
        //设置字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        PrintWriter out = resp.getWriter();
        //判断输入文本是否可用
        if("tom".equals(name)){
            out.write("不可用");
        }else{
            out.write("可用");
        }
        //关闭输出流
        out.flush();
        out.close();
    }
}
