package com.rabbit.ieasy.modules.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbit.ieasy.common.collect.MapUtils;
import com.rabbit.ieasy.modules.dao.EasySysLogMapper;
import com.rabbit.ieasy.modules.domain.EasySysLog;
import com.rabbit.ieasy.modules.dto.SysLogDTO;
import com.rabbit.ieasy.modules.service.IEasySysLogService;
import com.rabbit.ieasy.utils.QueryUtil;
import com.rabbit.ieasy.utils.ResultUtil;
import com.rabbit.ieasy.vo.Result;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 *@projectName ieasy
 *@packageName com.rabbit.ieasy.modules.service.impl
 *@description 操作日志表
 *@className   EasySysLogServiceImpl
 *@author      liyang
 *@createDate  2019-3-18 16:28
 */
@Service
public class EasySysLogServiceImpl extends ServiceImpl<EasySysLogMapper, EasySysLog> implements IEasySysLogService {

    @Override
    public Result<IPage<EasySysLog>> pageSysLog(SysLogDTO sysLogDTO) {
        Map<String,Object> map = new HashMap<>();
        try {
            map = MapUtils.toNavMap(sysLogDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        IPage<EasySysLog> accountInfoIPage = this.page(
                new QueryUtil<EasySysLog>(map).getPage()
        );
        return new ResultUtil< IPage<EasySysLog>>().oks(accountInfoIPage);
    }
}
