package com.learnservlet.tutorial;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubtractServlet extends HttpServlet {
        public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter SubtractServlet service function");
        int i=Integer.parseInt(req.getParameter("num1"));
        int j=Integer.parseInt(req.getParameter("num2"));
        int k=i-j;
        System.out.println("result is "+k);
        res.getWriter().println("result is "+k);
    }
}
