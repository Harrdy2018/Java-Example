package com.learnspock.tutorial.impl;
import com.learnspock.tutorial.service.DependencyService;
public class DependencyServiceImpl implements DependencyService{

    @Override
    public Boolean make(String param) {
        return "ok".equals(param);
    }
}
