package com.learnservlet.tutorial;

import javax.servlet.http.*;
import java.io.IOException;

public class AddOverCookieServlet extends HttpServlet {
    /**
     * 第一次交互
     * 前端页面第一次发起 http://localhost:8080/servlet_tutorial/addtestb?num1=123&num2=12
     * 下面方法在 response里面填入cookie
     * Cookie cookie=new Cookie("sum", k+"");
     * res.addCookie(cookie);
     * 得到的效果是下面这样
     * 后台给前端的第一次响应
     * ResonseHeaders
     *  Connection: keep-alive
     *  Content-Length: 0
     *  Date: Sat, 06 Nov 2021 05:28:37 GMT
     *  Keep-Alive: timeout=20
     *  Location: addprintb
     *  Set-Cookie: sum=135
     *
     * 第二次交互
     * 后台通过 Location字段通知前端重定向，发起请求
     * Request URL: http://localhost:8080/servlet_tutorial/addprintb
     * 前台携带cookie发起请求
     * RequestHeaders
     *  Accept-Language: zh-CN,zh;q=0.9
     *  Cache-Control: no-cache
     *  Connection: keep-alive
     *  Cookie: sum=135
     * @param req
     * @param res
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter AddOverCookieServlet doGet function");
        int i=Integer.parseInt(req.getParameter("num1"));
        int j=Integer.parseInt(req.getParameter("num2"));
        int k=i+j;
        Cookie cookie=new Cookie("sum", k+"");
        res.addCookie(cookie);
        res.sendRedirect("addprintb");
    }
}
