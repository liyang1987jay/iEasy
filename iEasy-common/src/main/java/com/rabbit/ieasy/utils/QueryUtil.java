package com.rabbit.ieasy.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liyang
 * @projectName snjt-bank
 * @packageName com.snjt.bank.util
 * @description
 * @className QueryUtil
 * @createDate 2019-03-29 2:18 PM
 */
public class QueryUtil<T> extends LinkedHashMap<String,Object> {
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    public QueryUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        if (params.get("pageIndex") != null) {
            currPage = Integer.parseInt((String) params.get("pageIndex"));
        }
        if (params.get("curr") != null) {
            currPage = Integer.parseInt((String) params.get("curr"));
        }
        if (params.get("pageSize") != null) {
            limit = Integer.parseInt((String) params.get("pageSize"));
        }

//        this.put("offset", (currPage - 1) * limit);
//        this.put("page", currPage);
//        this.put("limit", limit);

        //mybatis-plus分页
        this.page = new Page<T>(currPage, limit);


    }

    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }
}