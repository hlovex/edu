package com.hlovex.edu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by hlovex on 2021/2/12 23:19
 */
@Data
public class TeacherQuery {

    @ApiModelProperty("教师名称")
    private String name;

    @ApiModelProperty("头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "开始时间",example = "2021-01-01 01:01:01")
    private String begin;

    @ApiModelProperty(value = "结束时间",example = "2021-01-01 01:01:01")
    private String end;
}
