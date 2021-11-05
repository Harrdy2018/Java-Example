package com.learnservlet.tutorial;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SqServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter SqServlet doGet function");
        // 处理过来的重定向
        res.getWriter().println("Hello to Sq "+Integer.parseInt(req.getParameter("k")));
        // 处理过来的转发
        // res.getWriter().println("Hello to Sq "+(int)(req.getAttribute("k")));
    }
}
