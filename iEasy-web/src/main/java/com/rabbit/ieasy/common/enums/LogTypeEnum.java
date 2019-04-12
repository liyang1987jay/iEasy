package com.rabbit.ieasy.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.web.common.enums
 * @description
 * @className LogTypeEnum
 * @createDate 2019-03-28 8:59 PM
 */

@AllArgsConstructor
public enum LogTypeEnum {
    OPERATION("0","操作"),
    /**
     * 查询
     */
    SELECT_OPERATION("1","查询"),
    /**
     * 删除
     */
    DELETE_OPERATION("2","删除"),
    /**
     * 修改
     */
    UPDATE_OPERATION("3","修改"),
    /**
     * 增加
     */
    ADD_OPERATION("4","增加"),
    /**
     * 登录
     */
    LOGIN("5","登录"),
    /**
     * 退出
     */
    LOGOUT("6","退出")
    ;
    private String code;
    private String msg;

}
