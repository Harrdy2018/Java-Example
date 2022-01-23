package com.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.common.Person;
import com.learn.common.Result;
import com.learn.common.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorld extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("enter service HelloWorld ...");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        String ID = req.getParameter("id");
        Result result = null;
        if (ID == null) {
            result = Result.failure(ResultCode.PARAM_IS_INVALID);
        } else {
            Person xiaoming = new Person("xiaoming", 123);
            result = Result.success(xiaoming);
        }
        res.getWriter().write(JSONObject.toJSONString(result));
        
    }
}
