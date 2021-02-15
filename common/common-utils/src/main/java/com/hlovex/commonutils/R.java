package com.hlovex.commonutils;

import com.hlovex.commonutils.enums.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by hlovex on 2021/2/12 21:41
 */
@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 2065709524358697653L;
    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回消息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    private R() {
    }

    public static <T> R<T> ok() {
        R<T> r = new R<T>();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.code);
        r.setMessage(ResultCode.SUCCESS.desc);
        return r;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<T>();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.code);
        r.setMessage(ResultCode.SUCCESS.desc);
        r.setData(data);
        return r;
    }

    public static <T> R<T> fail(String message) {
        R<T> r = new R<T>();
        r.setSuccess(false);
        r.setCode(ResultCode.FAIL.code);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> fail(Integer code, String message) {
        R<T> r = new R<T>();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> fail(ResultCode resultCode) {
        R<T> r = new R<T>();
        r.setSuccess(false);
        r.setCode(resultCode.code);
        r.setMessage(resultCode.desc);
        return r;
    }

    public R<T> success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public R<T> data(T data) {
        this.setData(data);
        return this;
    }
}
