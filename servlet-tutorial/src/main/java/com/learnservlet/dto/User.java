package com.learnservlet.dto;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class User {
    @ExcelProperty("用户编号")
    private Integer userId;
    @ExcelProperty("用户名称")
    private String userName;
    @ExcelProperty("用户性别")
    private String gender;
    @ExcelProperty("创建时间")
    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public User(Integer userId, String userName, String gender, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.createTime = createTime;
    }
}
