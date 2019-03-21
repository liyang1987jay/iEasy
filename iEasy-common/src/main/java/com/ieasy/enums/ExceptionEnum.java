package com.ieasy.enums;

import lombok.Getter;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.enums
 * @description
 * @className ExceptionEnum
 * @createDate 2019-03-19 9:48 PM
 */
@Getter
public enum ExceptionEnum {
    APPLICATION_ERROR(500,"系统异常"),
    NOT_VALID_CHARACTER(501,"不合法的字符")
    ;
    private Integer code;

    private String message;
    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
