package com.ieasy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.config
 * @description
 * @className MybatisPlusConfig
 * @createDate 2019-03-19 9:35 PM
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.ctrl.education.dao")
public class MybatisPlusConfig {
}
