package com.rabbit.ieasy.common.annotation;

import java.lang.annotation.*;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.web.common.annotation
 * @description
 * @className BussinessLog
 * @createDate 2019-03-28 8:57 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BussinessLog {
    String description() default "";

    String type() default "0";
}
