package com.rabbit.ieasy.modules.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.rabbit.ieasy.base.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *@projectName ieasy
 *@packageName com.rabbit.ieasy.modules.domain
 *@description 操作日志表
 *@className   EasySysLog
 *@author      liyang
 *@createDate  2019-3-12 23:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="EasySysLog对象", description="操作日志表")
public class EasySysLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志类型")
    @TableField("log_type")
    private String logType;

    @ApiModelProperty(value = "日志标题")
    @TableField("log_title")
    private String logTitle;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "用户名称")
    @TableField("create_by_name")
    private String createByName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "请求URI")
    @TableField("request_uri")
    private String requestUri;

    @ApiModelProperty(value = "操作方式")
    @TableField("request_method")
    private String requestMethod;

    @ApiModelProperty(value = "操作提交的数据")
    @TableField("request_params")
    private String requestParams;

    @ApiModelProperty(value = "新旧数据比较结果")
    @TableField("diff_modify_data")
    private String diffModifyData;

    @ApiModelProperty(value = "业务主键")
    @TableField("biz_key")
    private String bizKey;

    @ApiModelProperty(value = "业务类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "操作IP地址")
    @TableField("remote_addr")
    private String remoteAddr;

    @ApiModelProperty(value = "请求服务器地址")
    @TableField("server_addr")
    private String serverAddr;

    @ApiModelProperty(value = "是否异常")
    @TableField("is_exception")
    private String isException;

    @ApiModelProperty(value = "异常信息")
    @TableField("exception_info")
    private String exceptionInfo;

    @ApiModelProperty(value = "用户代理")
    @TableField("user_agent")
    private String userAgent;

    @ApiModelProperty(value = "设备名称/操作系统")
    @TableField("device_name")
    private String deviceName;

    @ApiModelProperty(value = "浏览器名称")
    @TableField("browser_name")
    private String browserName;

    @ApiModelProperty(value = "执行时间")
    @TableField("execute_time")
    private BigDecimal executeTime;

    @ApiModelProperty(value = "租户代码")
    @TableField("corp_code")
    private String corpCode;

    @ApiModelProperty(value = "租户名称")
    @TableField("corp_name")
    private String corpName;


}
