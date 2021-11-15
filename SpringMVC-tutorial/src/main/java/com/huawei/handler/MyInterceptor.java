package com.huawei.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 拦截器
 * Ctrl+O 快捷键，重写方法
 * */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * preHandle 预先处理请求的方法
     * Object handler 被拦截的控制器对象
     * 在控制器方法之前执行
     * 可以对请求作处理，登陆检查，权限的判断，统计数据
     *
     * true: 请求时正确的，是能够被controller处理的
     * false: 请求是不被容许的，没视图，只有 preHandle执行
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor preHandle");
        // 设置为false之后搞一个提示
        // request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }

    /**
     * 控制器方法之后执行
     * 对请求的二次处理
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
        System.out.println("MyInterceptor postHandle");
        if(mv != null){
            mv.addObject("msg", "修改数据 处理了some.do请求");
            mv.addObject("func", "修改数据 执行了doSome方法");
            mv.addObject("mydate", new Date());
            // 修改视图
            mv.setViewName("other");
        }
        return;
    }

    /**
     * 在请求完成之后执行的，请求处理完成的标志，视图处理完成，对视图执行forward操作后
     * 可以做程序最后的操作，释放内存，清理临时变量
     * 方法执行条件
     *    preHandle必须执行，且返回true
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor afterCompletion");
        HttpSession session=request.getSession();
        Object attr=session.getAttribute("attr");
        System.out.println("attr="+attr);

        session.removeAttribute("attr");
        attr=session.getAttribute("attr");
        System.out.println("delete and check attr="+attr);
        return;
    }
}
