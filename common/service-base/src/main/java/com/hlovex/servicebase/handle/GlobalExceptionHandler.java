package com.hlovex.servicebase.handle;

import com.hlovex.commonutils.R;
import com.hlovex.commonutils.enums.ResultCode;
import com.hlovex.servicebase.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hlovex on 2021/2/13 0:43
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R<String> error(Exception e) {
        log.error(e.toString());
        return R.fail(ResultCode.FAIL);
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R<String> arithmeticError(Exception e) {
        log.error(e.toString());
        return R.fail(ResultCode.FAIL);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public R<String> customError(ServiceException e) {
        log.error(e.toString());
        return R.fail(e.getCode(), e.getMessage());
    }
}
