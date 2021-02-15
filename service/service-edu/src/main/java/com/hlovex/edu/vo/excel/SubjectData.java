package com.hlovex.edu.vo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by hlovex on 2021/2/15 15:09
 */
@Data
public class SubjectData implements Serializable {
    private static final long serialVersionUID = 5946070017919756048L;

    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
