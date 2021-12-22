package com.learnservlet.tutorial;

import com.alibaba.excel.EasyExcel;
import com.learnservlet.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelDownLoadServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("enter ExcelDownLoadServlet");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("demo","utf-8");
        response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");

        //构建写入到Excel中的数据(此数据可以从数据库中获取)
        List<User> users = new ArrayList<>();
        User user1 = new User(1001, "李雷1", "男", new Date());
        User user2 = new User(1002, "李雷2", "男", new Date());
        User user3 = new User(1003, "李雷3", "男", new Date());
        users.add(user1);
        users.add(user2);
        users.add(user3);
        EasyExcel.write(response.getOutputStream(), User.class)
                .sheet(0,"用户信息")
                .doWrite(users);

        // 问题： firfox中"content-disposition", "attachment;filename=“+filename不能显示文件名字
        // https://www.cnblogs.com/soficircle/p/6882900.html
    }
}
