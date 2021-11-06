package com.learnservlet.tutorial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddOverSessionServlet extends HelloServlet{
    /**
     * 第一次交互
     * 前台发起 Request URL: http://localhost:8080/servlet_tutorial/addtesta?num1=123&num2=456
     * 后台创建session,然后以cookie方式返回给前台
     * ResponseHeaders
     *  Connection: keep-alive
     *  Content-Length: 0
     *  Date: Sat, 06 Nov 2021 05:44:20 GMT
     *  Keep-Alive: timeout=20
     *  Location: addprint
     *  Set-Cookie: JSESSIONID=1D1F61D6504D83AD3EB7F47BE29AB1C5; Path=/servlet_tutorial; HttpOnly
     *
     * 第二次交互
     * 前台携带cookie根据location字段发起请求 Request URL: http://localhost:8080/servlet_tutorial/addprint
     * RequestHeaders
     *  Cache-Control: no-cache
     *  Connection: keep-alive
     *  Cookie: JSESSIONID=1D1F61D6504D83AD3EB7F47BE29AB1C5
     * @param req
     * @param res
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter AddOverSessionServlet doGet function");
        int i=Integer.parseInt(req.getParameter("num1"));
        int j=Integer.parseInt(req.getParameter("num2"));
        int k=i+j;
        HttpSession session=req.getSession();
        session.setAttribute("sum", k);
        res.sendRedirect("addprint");
    }
}
