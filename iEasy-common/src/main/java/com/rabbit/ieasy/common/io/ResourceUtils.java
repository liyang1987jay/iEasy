package com.rabbit.ieasy.common.io;

import com.rabbit.ieasy.common.lang.ExceptionUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.ieasy.core.core.io
 * @description 资源供给类
 * @className ResourceUtils
 * @createDate 2019-03-12 9:49 PM
 */
public class ResourceUtils extends org.springframework.util.ResourceUtils {

    private static ResourceLoader resourceLoader;
    private static ResourcePatternResolver resourceResolver;
    static{
        resourceLoader = new DefaultResourceLoader();
        resourceResolver = new PathMatchingResourcePatternResolver(resourceLoader);
    }

    /**
     * 获取资源加载器（可读取jar内的文件）
     * @author ThinkGem
     */
    public static ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    /**
     * 获取ClassLoader
     */
    public static ClassLoader getClassLoader() {
        return resourceLoader.getClassLoader();
    }

    /**
     * 获取资源加载器（可读取jar内的文件）
     */
    public static Resource getResource(String location) {
        return resourceLoader.getResource(location);
    }

    /**
     * 获取资源文件流（用后记得关闭）
     * @param location
     * @author ThinkGem
     * @throws IOException
     */
    public static InputStream getResourceFileStream(String location) throws IOException{
        Resource resource = resourceLoader.getResource(location);
        return resource.getInputStream();
    }

    /**
     * 获取资源文件内容
     * @param location
     * @author ThinkGem
     */
    public static String getResourceFileContent(String location){
        try(InputStream is = ResourceUtils.getResourceFileStream(location)){
            return IOUtils.toString(is, "UTF-8");
        }catch (IOException e) {
            throw ExceptionUtils.unchecked(e);
        }
    }

    /**
     * Spring 搜索资源文件
     * @param locationPattern
     * @author ThinkGem
     */
    public static Resource[] getResources(String locationPattern){
        try {
            Resource[] resources = resourceResolver.getResources(locationPattern);
            return resources;
        } catch (IOException e) {
            throw ExceptionUtils.unchecked(e);
        }
    }

}
