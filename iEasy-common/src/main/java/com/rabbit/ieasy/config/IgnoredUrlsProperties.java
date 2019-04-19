package com.rabbit.ieasy.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.config
 * @description
 * @className IgnoredUrlsProperties
 * @createDate 2019-03-19 9:33 PM
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "ignored")
public class IgnoredUrlsProperties {
    private List<String> urls = new ArrayList<>();
}
