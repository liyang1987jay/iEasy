package com.ieasy.xss;

import com.ieasy.common.lang.StringUtils;
import com.ieasy.enums.ExceptionEnum;
import com.ieasy.exception.IEasyException;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.xss
 * @description
 * @className SqlFilter
 * @createDate 2019-03-19 9:42 PM
 */
public class SqlFilter {
    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new IEasyException(ExceptionEnum.NOT_VALID_CHARACTER.getMessage());
            }
        }

        return str;
    }
}
