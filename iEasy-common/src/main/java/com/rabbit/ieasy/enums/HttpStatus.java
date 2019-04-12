package com.ieasy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.enums
 * @description http状态码枚举类
 * @className HttpStatus
 * @createDate 2019-03-31 8:28 PM
 */
@AllArgsConstructor
@Getter
public enum HttpStatus {
    OK(200, "成功"),
    BAD_REQUEST(400, "请求无效"),
    UNAUTHORIZED(401, "未经授权"),
    NOT_FOUND(404, "不存在的方法"),
    METHOD_NOT_ALLOWED(405, "方法不存在"),
    REQUEST_TIMEOUT(408, "请求超时"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    ;
    private Integer code;

    private String message;
}
