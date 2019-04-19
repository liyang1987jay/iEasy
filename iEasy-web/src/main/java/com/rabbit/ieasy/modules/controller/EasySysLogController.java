package com.rabbit.ieasy.modules.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rabbit.ieasy.modules.domain.EasySysLog;
import com.rabbit.ieasy.modules.dto.SysLogDTO;
import com.rabbit.ieasy.modules.service.IEasySysLogService;
import com.rabbit.ieasy.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rabbit.ieasy.base.BaseController;

/**
 *@projectName ieasy
 *@packageName com.rabbit.ieasy.modules.controller
 *@description 操作日志表
 *@className   EasySysLogController
 *@author      liyang
 *@createDate  2019-3-18 16:28
 */
@RestController
@RequestMapping("/easy-sys-log")
@Api(value = "系统日志",tags = "系统日志")
public class EasySysLogController extends BaseController {
    @Autowired
    private IEasySysLogService iEasySysLogService;
    @ApiOperation(value = "操作日志列表",notes = "操作日志列表")
    @PostMapping("/pageSysLog")
    public Result< IPage<EasySysLog>> pageSysLog(@RequestBody SysLogDTO sysLogDTO){
        Result<IPage<EasySysLog>> result =  iEasySysLogService.pageSysLog(sysLogDTO);
        return result;
    }

}

