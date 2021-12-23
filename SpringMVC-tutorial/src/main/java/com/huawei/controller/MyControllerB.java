package com.huawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyControllerB {
    @RequestMapping(value={"/any.cn"})
    public void doAny(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println("enter MyController doAny ...");
        res.getWriter().println("Hello World");
        return;
    }

//    @RequestMapping(value={"/**"})
//    public void doAnyAll(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        System.out.println("enter MyController doAnyAll ...");
//        System.out.println("req.getRequestURI  "+req.getRequestURI());
//        System.out.println("req.getRequestURL  "+req.getRequestURL());
//        // res.getWriter().println("Hello World");
//        return;
//    }
}
