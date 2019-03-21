package com.ieasy.utils;

import com.ieasy.enums.ServerEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.utils
 * @description
 * @className ResultUtilUtil
 * @createDate 2019-03-19 10:05 PM
 */
public class ResultUtil extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ResultUtil() {
        put("code", ServerEnum.APPLICATION_QUERY_SUCCESS.getCode());
        put("msg",ServerEnum.APPLICATION_QUERY_SUCCESS.getMessage());
    }

    public static ResultUtil error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ResultUtil error(String msg) {
        return error(500, msg);
    }

    public static ResultUtil error(int code, String msg) {
        ResultUtil r = new ResultUtil();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultUtil ok(String msg) {
        ResultUtil r = new ResultUtil();
        r.put("msg", msg);
        return r;
    }

    public static ResultUtil ok(Map<String, Object> map) {
        ResultUtil r = new ResultUtil();
        r.putAll(map);
        return r;
    }

    public static ResultUtil ok() {
        return new ResultUtil();
    }

    @Override
    public ResultUtil put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}