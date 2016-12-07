package com.mxiaixy.web;

import com.google.gson.Gson;
import com.mxiaixy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mxia on 2016/12/6.
 */
@WebServlet("/date.json")
public class JsonDateServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //设置MIME头
        resp.setContentType("application/json");

        //String json ="{\"id\":123,\"name\":\"jack\",\"address\":\"北京\"}";

        User user = new User(123,"tom","上海");
        User user1 = new User(124,"rose","深圳");
        User user2 = new User(125,"maid","广州");

        List<User>  userList = new ArrayList<>();

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        //引入jar包能自动把数组转成json格式
        //把数组转换json格式
        Gson gson = new Gson();
        String json = gson.toJson(userList);


        PrintWriter out = resp.getWriter();
        //输出到页面
        out.write(json);
        out.flush();
        out.close();
    }
}
