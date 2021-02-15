package com.hlovex.commonutils.enums;

import java.util.Objects;

/**
 * Created by hlovex on 2021/2/12 12:18
 */
public enum ResultCode {

    SUCCESS(20000, "操作成功"),
    FAIL(50000, "操作失败");

    public Integer code;

    public String desc;

    ResultCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCode from(Integer code) throws IllegalArgumentException {
        for (ResultCode codeEnum : ResultCode.values()) {
            if (Objects.equals(codeEnum.code, code)) {
                return codeEnum;
            }
        }
        throw new IllegalArgumentException("code is not exist");
    }
}
