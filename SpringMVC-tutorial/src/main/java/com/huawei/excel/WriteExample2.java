package com.huawei.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.huawei.dto.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteExample2 {
    public static void main(String[] args) {
        String fileName = "user2.xlsx";
        List<User> users = new ArrayList<>();
        User user1 = new User(1001,"李雷","男",1000.123,new Date());
        User user2 = new User(1002,"李雷","男",1000.123,new Date());
        User user3 = new User(1003,"李雷","男",1000.123,new Date());
        User user4 = new User(1004,"李雷","男",1000.123,new Date());
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        //创建Excel写对象
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        //创建sheet对象
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "用户信息").build();
        //将数据写到sheet标签中
        excelWriter.write(users, writeSheet);
        //关闭流,文件流手动关闭
        excelWriter.finish();
    }
}
