package com.rabbit.ieasy.exception;

import com.rabbit.ieasy.enums.HttpStatus;
import com.rabbit.ieasy.utils.ResultUtil;
import com.rabbit.ieasy.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.exception
 * @description 全局异常
 * @className RestCtrlExceptionHandler
 * @createDate 2019-03-31 8:23 PM
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class RestCtrlExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ResponseBody
    @ExceptionHandler(IEasyException.class)
    public Result<Object> handleRRException(IEasyException iEasyException) {
        return new ResultUtil<Object>().error(iEasyException.getCode(),iEasyException.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(DuplicateKeyException.class)
    public Result<Object> handleDuplicateKeyException(DuplicateKeyException duplicateKeyException) {
        return new ResultUtil<Object>().error("数据库中已存在该记录");
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e, HttpServletRequest request) {
        log.error("msg:{},url:{}", e.getMessage(), request.getRequestURL());
        return new ResultUtil<Object>().error(HttpStatus.NOT_FOUND.getCode(),HttpStatus.NOT_FOUND.getMessage());
    }
}
