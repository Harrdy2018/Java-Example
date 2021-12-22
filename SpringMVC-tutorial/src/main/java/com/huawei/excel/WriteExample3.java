package com.huawei.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.huawei.dto.User;

import java.util.*;

public class WriteExample3 {
    public static void main(String[] args) {
        String fileName = "user3.xlsx";
        List<User> users = new ArrayList<>();
        User user1 = new User(1001,"李雷","男",1000.123,new Date());
        User user2 = new User(1002,"李雷","男",1000.123,new Date());
        User user3 = new User(1003,"李雷","男",1000.123,new Date());
        User user4 = new User(1004,"李雷","男",1000.123,new Date());
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        // 设置排除的属性
        Set<String> set = new HashSet<>();
        set.add("hireDate");
        set.add("salary");

        // write Excel
        EasyExcel.write(fileName, User.class)
                .excludeColumnFiledNames(set)
                .sheet(0, "test 03")
                .doWrite(users);
    }
}
