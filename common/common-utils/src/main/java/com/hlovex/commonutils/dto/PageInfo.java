package com.hlovex.commonutils.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hlovex on 2021/2/12 22:16
 */
@Data
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 6524817213260068485L;

    private Long total;

    private List<T> rows;

    public PageInfo() {
    }

    public PageInfo(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
