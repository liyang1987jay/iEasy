package com.ieasy.exception;

import com.ieasy.enums.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.exception
 * @description ieay异常
 * @className IEasyException
 * @createDate 2019-03-19 9:44 PM
 */
@Data
@AllArgsConstructor
public class IEasyException extends RuntimeException {
    private String msg;
    private int code = HttpStatus.OK.getCode();
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
