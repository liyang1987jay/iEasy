package com.ieasy.exception;

import com.ieasy.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.exception
 * @description 全局异常
 * @className RestCtrlExceptionHandler
 * @createDate 2019-03-31 8:23 PM
 */
@Slf4j
@RestControllerAdvice
public class RestCtrlExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(IEasyException.class)
    public ResultUtil handleRRException(IEasyException alohaException) {
        ResultUtil ResultUtil = new ResultUtil();
        ResultUtil.put("code", alohaException.getCode());
        ResultUtil.put("msg", alohaException.getMessage());

        return ResultUtil;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResultUtil handleDuplicateKeyException(DuplicateKeyException duplicateKeyException) {
        return ResultUtil.error("数据库中已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public ResultUtil handleException(Exception exception) {
        return ResultUtil.error();
    }
}
