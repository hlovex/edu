package com.hlovex.edu.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlovex on 2021/2/15 22:07
 */
@Data
public class SubjectVo implements Serializable {
    private static final long serialVersionUID = 6484261605953636329L;

    private Long id;

    private String title;

    private List<SubjectVo> children = new ArrayList<>();
}
