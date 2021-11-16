package com.huawei.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 拦截器的执行顺序
 * 条件：MyInterceptorA preHandle=true；MyInterceptorB preHandle=true
 * 结果：
 * MyInterceptor aaa preHandle
 * MyInterceptor bbb preHandle
 * enter MyController ...
 * MyInterceptor bbb postHandle
 * MyInterceptor aaa postHandle
 * MyInterceptor bbb afterCompletion
 * MyInterceptor aaa afterCompletion
 *
 * 条件：MyInterceptorA preHandle=true；MyInterceptorB preHandle=false
 * 结果：
 * MyInterceptor aaa preHandle
 * MyInterceptor bbb preHandle
 * MyInterceptor aaa afterCompletion
 *
 * 条件：MyInterceptorA preHandle=false；MyInterceptorB preHandle=false|true
 * 结果：
 * MyInterceptor aaa preHandle
 *
 * 总结：HandlerExecutionChain 多个拦截器和一个控制对象在一个链条上
 * */
public class MyInterceptorA implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        System.out.println("MyInterceptor aaa preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mv) throws Exception {
        System.out.println("MyInterceptor aaa postHandle");
        return;
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor aaa afterCompletion");
        return;
    }
}
