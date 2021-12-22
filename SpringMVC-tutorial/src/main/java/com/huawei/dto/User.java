package com.huawei.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.*;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

//头背景设置成红色 IndexedColors.RED.getIndex()
@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 10)
//头字体设置成20
@HeadFontStyle(fontHeightInPoints = 20)
//内容的背景设置成绿色 IndexedColors.GREEN.getIndex()
@ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 17)
//内容字体设置成20
@ContentFontStyle(fontHeightInPoints = 20)
@ContentRowHeight(20) //设置内容高度
@HeadRowHeight(40)    //设置标题高度
@ColumnWidth(25)      //设置列宽
public class User {
    @ExcelProperty(value = "用户编号", index = 0)
    private Integer userId;
    // 字符串的头背景设置成粉红 IndexedColors.PINK.getIndex()
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 14)
    // 字符串的头字体设置成20
    @HeadFontStyle(fontHeightInPoints = 30)
    // 字符串的内容的背景设置成天蓝 IndexedColors.SKY_BLUE.getIndex()
    @ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 40)
    // 字符串的内容字体设置成20
    @ContentFontStyle(fontHeightInPoints = 30)
    @ExcelProperty(value = "姓名", index = 1)
    private String userName;
    @ExcelProperty(value = "性别", index = 2)
    private String gender;
    //格式化小数类型,如果是百分数那么定义为  #.##% 比如:9.12%
    @NumberFormat("#.##")
    @ExcelProperty(value = "工资", index = 4)
    private Double salary;
    @ColumnWidth(50)
    @DateTimeFormat("yyyy年MM月dd日 HH时mm分ss秒")
    @ExcelProperty(value = "入职时间", index = 3)
    private Date hireDate;

    public User(Integer userId, String userName, String gender, Double salary, Date hireDate) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
