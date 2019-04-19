package com.rabbit.ieasy.modules.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rabbit.ieasy.modules.domain.EasySysLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rabbit.ieasy.modules.dto.SysLogDTO;
import com.rabbit.ieasy.vo.Result;

/**
 *@projectName ieasy
 *@packageName com.rabbit.ieasy.modules.service
 *@description 操作日志表
 *@className   IEasySysLogService
 *@author      liyang
 *@createDate  2019-3-18 16:28
 */
public interface IEasySysLogService extends IService<EasySysLog> {
    Result<IPage<EasySysLog>> pageSysLog(SysLogDTO sysLogDTO);

}
