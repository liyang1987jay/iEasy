package com.ieasy.exception;

import com.ieasy.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.exception
 * @description
 * @className IEasyException
 * @createDate 2019-03-19 9:44 PM
 */
@Getter
@Setter
@AllArgsConstructor
public class IEasyException extends RuntimeException {
    private String msg;
    private int code = ExceptionEnum.APPLICATION_ERROR.getCode();
    public IEasyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public IEasyException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }
    public IEasyException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
