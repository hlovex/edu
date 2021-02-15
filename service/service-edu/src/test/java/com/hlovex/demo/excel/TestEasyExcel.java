package com.hlovex.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlovex on 2021/2/15 13:04
 */
public class TestEasyExcel {
    public static void main(String[] args) {
        // 设置写入文件地址和excel文件名称
        String filename = "D:/write.xlsx";

        // 调用easyexcel里面的方法实现写操作
        EasyExcel.write(filename, DemoData.class).sheet("学生列表").doWrite(getData());
    }

    static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("name_" + i);
            list.add(data);
        }
        return list;
    }
}
