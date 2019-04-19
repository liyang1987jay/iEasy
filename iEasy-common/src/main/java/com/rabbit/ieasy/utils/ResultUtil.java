package com.rabbit.ieasy.utils;

import com.rabbit.ieasy.enums.HttpStatus;
import com.rabbit.ieasy.vo.Result;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.utils
 * @description
 * @className ResultUtilUtil
 * @createDate 2019-03-19 10:05 PM
 */
public class ResultUtil<T> {

    private Result<T> result;

    public ResultUtil() {
        result = new Result<>();
        result.setCode(HttpStatus.OK.getCode());
        result.setSuccess(true);
        result.setMessage(HttpStatus.OK.getMessage());
    }

    public Result<T> error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.getCode(), HttpStatus.INTERNAL_SERVER_ERROR.getMessage());
    }

    public Result<T> error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public Result<T> error(int code, String msg) {
        this.result.setMessage(msg);
        this.result.setCode(code);
        this.result.setSuccess(false);
        return this.result;
    }

    public Result<T> ok(String msg) {
        this.result.setMessage(msg);
        return this.result;
    }

    public Result<T> oks(T t) {
        this.result.setCode(HttpStatus.OK.getCode());
        this.result.setResult(t);
        return this.result;
    }

    public Result<T> oks(T t, String msg) {
        this.result.setResult(t);
        this.result.setCode(HttpStatus.OK.getCode());
        this.result.setMessage(msg);
        this.result.setSuccess(true);
        return this.result;
    }

}