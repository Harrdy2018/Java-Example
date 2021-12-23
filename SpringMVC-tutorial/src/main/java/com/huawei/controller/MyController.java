package com.huawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MyController {
    @RequestMapping(value="/some.do")
    public ModelAndView doSome(HttpSession session){
        System.out.println("enter MyController ...");
        // 添加一个临时数据
        session.setAttribute("attr", "在conroller中增加的临时数据");
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg", "处理了some.do请求");
        mv.addObject("func", "执行了doSome方法");
        // 指定视图 [/webapp/WEB-INF/pages/show.jsp]
        // mv.setViewName("/WEB-INF/pages/show.jsp");
        // 配置了视图解析器之后
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value={"/you.do", "/you/you.do", "/you/you/you.do"})
    public void doAll(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println("enter MyController doAll ...");
        res.getWriter().println("Hello World");
        return;
    }
}

