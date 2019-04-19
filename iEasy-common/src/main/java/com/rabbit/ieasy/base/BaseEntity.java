package com.rabbit.ieasy.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rabbit.ieasy.utils.SnowFlakeUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.web
 * @description
 * @className BaseEntity
 * @createDate 2019-03-28 10:01 PM
 */
@Data
public abstract class BaseEntity<T extends Model> extends Model {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id")
    @ApiModelProperty(value = "唯一标识")
    @CreatedBy
    private String id =String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @TableId(value = "create_By")
    @ApiModelProperty(value = "创建者")
    private String createBy;

    @TableField(value="create_date", fill = FieldFill.INSERT)
    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

//    @TableId(value = "update_By")
//    @ApiModelProperty(value = "更新者")
//    private String updateBy;
    /**
     * 更新日期<br>
     * @TableField注解说明：<br>
     *
     * <h1>1、value属性：</h1>
     * 生成sql时，实体属性（例如modifyDate）对应数据库表的列名（表字段，例如modify_date）。<br>
     *
     * <h1>2、fill属性：</h1>
     * 指定数据库表的字段的填充策略，各枚举值含义请自己看源码。<br>
     * 配置该属性，在执行insert、update等SQL时，如果策略匹配成功，就会在生成的SQL中自动追加新增、更新该字段的内容，<br>
     * 并且该字段的取值会通过MetaObjectHandler类的insertFill、updateFill等对应方法中的设置进行赋值。<br>
     * 如果通过该填充策略给数据库表字段自动填充值时，必须自己实现MetaObjectHandler抽象类，并注册到mybatis的全局配置中去。<br>
     * 请参考mybatis-plug自动填充功能：{@link https://mp.baomidou.com/guide/auto-fill-metainfo.html}<br>
     * springBoot的配置：{@link https://www.cnblogs.com/lqtbk/p/9843401.html}<br>
     * 本项目中MetaObjectHandler的实现类未：{@link com.rabbit.ieasy.config.ModelMetaObjectHandler}<br>
     * <b>注意：</b><br>
     * 如果该注解同时设置了“update属性”(见下)，且fill属性取值为UPDATE或INSERT_UPDATE，那么fill属性优先级高于update属性，会导致设置的update属性策略失效！！！<br>
     *
     * <h1>3、update属性：</h1>
     * 对实体进行update操作时，生成的update SQL，会注入该字段的更新。<br>
     * 例如：<br>
     * update="NOW()"，则生成的SQL中会含“update ... set ..., modify_date = NOW()”<br>
     * update="%s+1"，则生成的SQL中会含“update ... set ..., version = version + 1<br>
     * <b>注意：</b><br>
     * 如果该注解同时设置了“fill属性”(见上)，且fill属性取值为UPDATE或INSERT_UPDATE，那么fill属性优先级高于update属性，会导致设置的update属性策略失效！！！<br>
     *
     * <h1>优先级总结：</h1>
     * 实体属性更新到数据库时，属性值来源的优先级：实体类对象setter设置的值 &gt; fill策略填充的值 &gt; update策略SQL注入的值。<br>
     * <b>注意：</b><br>
     * setter优先级和fill策略优先级，是在MetaObjectHandler中自己手动实现的。
     */
//    @TableField(value="update_date", fill = FieldFill.INSERT, update="NOW()")
//    @LastModifiedDate
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty(value = "更新时间")
//    private Date updateDate;
}
