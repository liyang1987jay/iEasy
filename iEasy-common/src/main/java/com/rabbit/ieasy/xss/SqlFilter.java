package com.rabbit.ieasy.xss;

import com.rabbit.ieasy.common.lang.StringUtils;
import com.rabbit.ieasy.exception.IEasyException;
import com.rabbit.ieasy.enums.BusinessStatusEnum;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.xss
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
                throw new IEasyException(BusinessStatusEnum.NOT_VALID_CHARACTER.getMessage());
            }
        }

        return str;
    }
}
