package com.ieasy.enums;

import lombok.Getter;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.enums
 * @description
 * @className ServerEnum
 * @createDate 2019-03-19 10:07 PM
 */
@Getter
public enum ServerEnum {
    APPLICATION_QUERY_SUCCESS(10000,"查询成功"),
    APPLICATION_QUERY_FAIL(10001,"查询失败"),
            ;
    private Integer code;

    private String message;
    ServerEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
