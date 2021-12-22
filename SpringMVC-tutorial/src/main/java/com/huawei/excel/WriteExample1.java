package com.huawei.excel;

import com.alibaba.excel.EasyExcel;
import com.huawei.dto.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteExample1 {
    public static void main(String[] args) {
        String fileName = "user1.xlsx";
        List<User> users = new ArrayList<>();
        User user1 = new User(1001,"李雷","男",1000.1234,new Date());
        User user2 = new User(1002,"李雷","男",1000.1234,new Date());
        User user3 = new User(1003,"李雷","男",1000.1234,new Date());
        User user4 = new User(1004,"李雷","男",1000.1234,new Date());
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        EasyExcel.write(fileName, User.class)
                .sheet(0, "用户信息")
                .doWrite(users);
    }
}
