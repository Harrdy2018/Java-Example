package com.learnspock.tutorial.impl;

import com.learnspock.tutorial.service.DependencyService;
import com.learnspock.tutorial.service.MyService;

public class MyServiceImpl implements MyService {
    public DependencyService dependencyService;

    public MyServiceImpl(DependencyService dependencyService){
        this.dependencyService=dependencyService;
    }

    @Override
    public Boolean makeDecision(String request){
        System.out.println("MyServiceImpl String request "+request);
        return this.dependencyService.make(request);
    }
}
