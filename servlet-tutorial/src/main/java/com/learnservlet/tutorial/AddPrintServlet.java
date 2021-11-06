package com.learnservlet.tutorial;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddPrintServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter AddPrintServlet doGet function");
        HttpSession session=req.getSession();
        int sum= (int) session.getAttribute("sum");
        res.getWriter().println("calculate i+j over session result is "+sum);
    }
}
