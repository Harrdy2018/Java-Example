package com.learnservlet.tutorial;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter HelloServlet doGet function");
        res.getWriter().println("Hello "+req.getAttribute("info"));
    }
}
