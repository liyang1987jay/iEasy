package com.rabbit.ieasy.modules.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.modules.dto
 * @description
 * @className SysLogDTO
 * @createDate 2019-04-18 4:48 PM
 */
@Data
public class SysLogDTO {
    /**
     * 日志类型
     */
    @ApiModelProperty(value = "日志类型",dataType = "string")
    private String logType;

    /**
     * 日志标题
     */
    @ApiModelProperty(value = "日志标题",dataType = "string")
    private String logTitle;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称",dataType = "string")
    private String createByName;

    @ApiModelProperty(value = "开始时间",dataType = "string",example = "2019-04-11")
    private String startDate;
    @ApiModelProperty(value = "结束时间",dataType = "string",example = "2019-04-11")
    private String endDate;

}
