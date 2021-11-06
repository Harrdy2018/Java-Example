package com.learnservlet.tutorial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("enter ForwardServlet doGet function");
        String account=req.getParameter("account");
        String passsword=req.getParameter("password");
        req.setAttribute("info", "account "+account+" password "+passsword);
        RequestDispatcher rd=req.getRequestDispatcher("hello");
        rd.forward(req,res);
        return;
    }
}
