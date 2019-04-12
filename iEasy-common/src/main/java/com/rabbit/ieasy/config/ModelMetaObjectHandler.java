package com.rabbit.ieasy.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.omg.CORBA.IDLType;

import java.util.Date;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.core
 * @description
 * @className ModelMetaObjectHandler
 * @createDate 2019-04-12 11:17 PM
 */
public class ModelMetaObjectHandler implements MetaObjectHandler {
    /**
     * metaObject是页面传递过来的参数的包装对象，不是从数据库取的持久化对象，因此页面传过来哪些值，metaObject里就有哪些值。
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        Object id = this.getFieldValByName("id", metaObject);
        Object createDate = this.getFieldValByName("createDate", metaObject);
        if(null == createDate){
            /**
             * 设置实体属性setter进去的值，优先级要高于自动填充的值。
             * 如果实体没有设置该属性，就给默认值，防止entity的setter值被覆盖。
             */
            this.setFieldValByName("createDate", now, metaObject);
        }
        Object modifyDate = this.getFieldValByName("updateDate", metaObject);
        if(null == modifyDate){
            this.setFieldValByName("updateDate", now, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    }
}
