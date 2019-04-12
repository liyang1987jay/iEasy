package com.ieasy.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.config
 * @description
 * @className FastJsonConfiguration
 * @createDate 2019-03-28 8:14 PM
 */
@Slf4j
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurationSupport {

    /**
     * 功能描述:  修改自定义消息转换器
     *
     * @author: liyang
     * @param:
     * @return:
     * @date: 2019/3/28 8:22 PM
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfiguration = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfiguration.setSerializerFeatures(
                // 防止循环引用
                SerializerFeature.DisableCircularReferenceDetect,
                // 空集合返回[],不返回null
                SerializerFeature.WriteNullListAsEmpty,
                // 空字符串返回"",不返回null
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteMapNullValue
        );
        fastJsonConfiguration.setDateFormat("yyyy-MM-dd HH:mm:ss");
        ValueFilter valueFilter = new ValueFilter() {
            @Override
            public Object process(Object o, String s, Object o1) {
                if (null == o1) {
                    o1 = "";
                }
                return o1;
            }
        };
        fastJsonConfiguration.setCharset(Charset.forName("utf-8"));
        fastJsonConfiguration.setSerializeFilters(valueFilter);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);

        //解决Long转json精度丢失的问题
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfiguration.setSerializeConfig(serializeConfig);
        fastConverter.setFastJsonConfig(fastJsonConfiguration);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastConverter);
    }
}
