package com.rabbit.ieasy.modules.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.rabbit.ieasy.base.BaseEntity;
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
 *@createDate  2019-3-18 16:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="EasySysLog对象", description="操作日志表")
public class EasySysLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 日志类型
     */
    @ApiModelProperty(value = "日志类型")
    @TableField("log_type")
    private String logType;

    /**
     * 日志标题
     */
    @ApiModelProperty(value = "日志标题")
    @TableField("log_title")
    private String logTitle;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    @TableField("create_by_name")
    private String createByName;

    /**
     * 请求URI
     */
    @ApiModelProperty(value = "请求URI")
    @TableField("request_uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @ApiModelProperty(value = "操作方式")
    @TableField("request_method")
    private String requestMethod;

    /**
     * 操作提交的数据
     */
    @ApiModelProperty(value = "操作提交的数据")
    @TableField("request_params")
    private String requestParams;

    /**
     * 新旧数据比较结果
     */
    @ApiModelProperty(value = "新旧数据比较结果")
    @TableField("diff_modify_data")
    private String diffModifyData;

    /**
     * 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    @TableField("biz_key")
    private String bizKey;

    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型")
    @TableField("biz_type")
    private String bizType;

    /**
     * 操作IP地址
     */
    @ApiModelProperty(value = "操作IP地址")
    @TableField("remote_addr")
    private String remoteAddr;

    /**
     * 请求服务器地址
     */
    @ApiModelProperty(value = "请求服务器地址")
    @TableField("server_addr")
    private String serverAddr;

    /**
     * 是否异常
     */
    @ApiModelProperty(value = "是否异常")
    @TableField("is_exception")
    private String isException;

    /**
     * 异常信息
     */
    @ApiModelProperty(value = "异常信息")
    @TableField("exception_info")
    private String exceptionInfo;

    /**
     * 用户代理
     */
    @ApiModelProperty(value = "用户代理")
    @TableField("user_agent")
    private String userAgent;

    /**
     * 设备名称/操作系统
     */
    @ApiModelProperty(value = "设备名称/操作系统")
    @TableField("device_name")
    private String deviceName;

    /**
     * 浏览器名称
     */
    @ApiModelProperty(value = "浏览器名称")
    @TableField("browser_name")
    private String browserName;

    /**
     * 执行时间
     */
    @ApiModelProperty(value = "执行时间")
    @TableField("execute_time")
    private BigDecimal executeTime;

    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    @TableField("corp_code")
    private String corpCode;

    /**
     * 租户名称
     */
    @ApiModelProperty(value = "租户名称")
    @TableField("corp_name")
    private String corpName;


}
