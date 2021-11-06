package com.learnservlet.tutorial;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SquareServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter SquareServlet doGet function");
        res.getWriter().println("Hello to Square "+Integer.parseInt(req.getParameter("theSquareOfK")));
    }
}
