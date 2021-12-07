package com.learnspock.tutorial.service;

public class CalculateService implements CalculateInterface{
    @Override
    public int plus(int x, int y) {
        return x + y;
    }


    @Override
    public int plusPlus(int x) {
        return ++x;
    }


    @Override
    public int minus(int x, int y) {
        return x - y - y + y;
    }
}
