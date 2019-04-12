package com.rabbit.ieasy.generator;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.io.File;
import java.util.*;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.web.generator
 * @description
 * @className CodeGenerator
 * @createDate 2019-04-12 8:53 PM
 */
public class CodeGenerator {
    /**
     * 数据库连接
     */
    private static final String dbUrl = "jdbc:mysql://localhost:3306/ieasy?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "12345678";
    /**
     * 包名
     */
    private static final String packageName = "com.rabbit.ieasy.modules";
    /**
     * 作者
     */
    private static final String author = "liyang";
    /**
     * 项目模块路径
     */
    private static final String outputDir = "/src/main/java";
    /**
     * mapper.xml输出路径
     */
    private static final String outputDir4MapperXml = new File("iEasy-web") + "/src/main/resources/mapper/";
    /**
     * 需要生成的表名
     */
    private static final String tableNames = "easy_sys_log";
    /**
     * 基础实体类
     */
    private static final String superEntityColumns = "id,create_by,create_date";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir((new File("iEasy-web")).getAbsolutePath() + outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        /**
         * 是否开启XML 二级缓存
         */
        gc.setEnableCache(false);
        /**
         * XML ResultMap
         */
        gc.setBaseResultMap(true);
        /**
         * XML columList
         */
        gc.setBaseColumnList(true);
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setIdType(IdType.ID_WORKER);
        /**
         * 是否开启实体属性 Swagger2 注解
         */
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        /**
         * 数据源配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(driver);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        /**
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("sys");
        pc.setParent(packageName);
        pc.setEntity("domain");
        pc.setMapper("dao");
        pc.setXml("dao.mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        /**
         * 自定义配置
         */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                // 作者
                map.put("PROJECT_NAME", "ieasy");
                Date date = DateUtil.date();
                // 年
                map.put("YEAR", DateUtil.year(date));
                // 月
                map.put("MONTH", DateUtil.month(date));
                // 日
                map.put("DAY", DateUtil.dayOfMonth(date));
                // 时分
                String minute = String.valueOf(DateUtil.minute(date)).length() == 1 ?
                        "0" + DateUtil.minute(date) : String.valueOf(DateUtil.minute(date));
                String time = DateUtil.hour(date, true) + ":" + minute;
                map.put("TIME", time);
                this.setMap(map);
            }
        };
        /**
         * 使用velocity模板引擎
         */
        String templatePath = "/templates/mapper.xml.vm";

        /**
         * 自定义输出配置
         */
        List<FileOutConfig> focList = new ArrayList<>();
        /**
         * 自定义配置会被优先输出
         */
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                /**
                 * 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                 */
                return outputDir4MapperXml
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        /**
         * 配置模板
         */
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setController("templates/controller.java");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        templateConfig.setMapper("templates/mapper.java");

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        /**
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.rabbit.ieasy.base.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setEntityBuilderModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.rabbit.ieasy.base.BaseController");
        /**
         * 表名，多个英文逗号分割
         */
        strategy.setInclude((tableNames).split(","));
        strategy.setSuperEntityColumns((superEntityColumns).split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }
}
