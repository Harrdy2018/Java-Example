package com.learnservlet.tutorial;

import javax.servlet.http.*;
import java.io.IOException;

public class AddPrintBServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("enter AddPrintBServlet doGet function");
        Cookie cookies[]=req.getCookies();
        int sum=0;
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("sum")){
                sum=Integer.parseInt(cookie.getValue());
            }
        }
        res.getWriter().println("calculate i+j over cookie result is "+sum);
    }
}
