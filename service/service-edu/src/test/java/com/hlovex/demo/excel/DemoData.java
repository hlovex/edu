package com.hlovex.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Created by hlovex on 2021/2/15 12:47
 */
@Data
public class DemoData {
    // 设置excel表头名称
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名", index = 1)
    private String sname;
}
