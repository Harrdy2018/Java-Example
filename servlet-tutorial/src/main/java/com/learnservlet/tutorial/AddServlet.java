package com.learnservlet.tutorial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
//    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        System.out.println("enter service function");
//        int i=Integer.parseInt(req.getParameter("num1"));
//        int j=Integer.parseInt(req.getParameter("num2"));
//        int k=i+j;
//        System.out.println("result is "+k);
//        res.getWriter().println("result is "+k);
//    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("enter doGet function");
        int i=Integer.parseInt(req.getParameter("num1"));
        int j=Integer.parseInt(req.getParameter("num2"));
        int k=i+j;
        k=k*k;

        // 转发
        /*
        req.setAttribute("k", k);
        RequestDispatcher rd=req.getRequestDispatcher("sq");
        rd.forward(req,res);
        */

        // 重定向
        res.sendRedirect("sq?k="+k);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter doPost function");
        int i=Integer.parseInt(req.getParameter("num1"));
        int j=Integer.parseInt(req.getParameter("num2"));
        int k=i+j;
        res.getWriter().println("result is "+k);
    }
}
