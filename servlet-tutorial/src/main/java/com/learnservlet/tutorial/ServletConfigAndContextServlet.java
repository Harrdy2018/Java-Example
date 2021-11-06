package com.learnservlet.tutorial;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletConfigAndContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out=res.getWriter();
        out.print("Hi<br>");
        ServletContext ctx=getServletContext();
        String name=ctx.getInitParameter("name");
        out.println(name);
        String phone=ctx.getInitParameter("phone");
        out.println(phone);
        ServletConfig cfg=getServletConfig();
        String cfgName=cfg.getInitParameter("name");
        out.println(cfgName);
        return;
    }
}
