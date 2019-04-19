package com.rabbit.ieasy.base;

import com.rabbit.ieasy.support.HttpKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.base
 * @description
 * @className BaseCongtroller
 * @createDate 2019-03-31 10:36 PM
 */
public class BaseController {
    public HttpServletRequest getHttpServletRequest() {
        return HttpKit.getRequest();
    }

    public HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }

}
