package com.huawei.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptorVerify implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        System.out.println("MyInterceptorVerify preHandle");
        String username="";
        Object attr=req.getSession().getAttribute("username");
        if(attr != null){
            username=(String)attr;
        }
        if("zhangsan".equals(username)){
            return true;
        }
        req.getRequestDispatcher("/tips.jsp").forward(req,res);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mv) throws Exception {
        System.out.println("MyInterceptorVerify postHandle");
        return;
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptorVerify afterCompletion");
        return;
    }
}
