package com.rabbit.ieasy.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.enums
 * @description 业务状态枚举类
 * @className BusinessStatusEnum
 * @createDate 2019-03-31 8:50 PM
 */
@Getter
@AllArgsConstructor
public enum BusinessStatusEnum {
    NOT_VALID_CHARACTER(10000, "不合法的字符"),
    PRAMA_NOT_NULL(10001, "参数不能为空"),
    PARAM_ERROR(10002, "参数错误"),
    QUERY_SUCCESS(10003, "查询成功"),
    QUERY_FAIL(10004, "查询失败"),
    MODIFY_SUCCESS(10005, "修改成功"),
    MODIFY_FAIL(10006, "修改失败"),
    SAVE_SUCCESS(10007, "保存成功"),
    SAVE_FAIL(10008, "保存失败"),
    REMOVE_SUCCESS(10009, "删除成功"),
    REMOVE_FAIL(10010, "删除失败"),
    ENABLE_SUCCESS(10011, "启用成功"),
    ENABLE_FAIL(10012, "启用失败"),
    DISABLE_SUCCESS(10013, "禁用成功"),
    DISABLE_FAIL(10014, "禁用失败"),
    RESULT_FLAG(10015,"result"),
    PAGE_TOTAL(10016,"total")
    ;
    private Integer code;

    private String message;
}
