package com.huawei.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestExcel {
    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            DemoData data = new DemoData();
            data.setString("字符串"+i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    public void simpleWrite(){
        String fileName = "EasyTest.xlsx";
        EasyExcel.write(fileName, DemoData.class)
                .sheet(0, "template01")
                .doWrite(data());
    }
}
