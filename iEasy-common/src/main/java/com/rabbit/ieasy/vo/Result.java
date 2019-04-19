package com.rabbit.ieasy.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.utils
 * @description
 * @className Result
 * @createDate 2019-04-19 1:22 PM
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 失败消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;

}
