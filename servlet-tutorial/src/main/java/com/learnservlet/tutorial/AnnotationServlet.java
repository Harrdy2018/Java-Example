package com.learnservlet.tutorial;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WebServlet 注解
 * 无须在web.xml文件书写servlet的配置信息
 */
@WebServlet(
        name="Annotation",
        urlPatterns = {"/testannotationa", "/testannotationb"},
        loadOnStartup = 1
)
public class AnnotationServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter pw=res.getWriter();
        pw.println("how to use annotation");
    }
}
