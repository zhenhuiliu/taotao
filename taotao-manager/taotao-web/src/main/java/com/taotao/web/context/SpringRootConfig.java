package com.taotao.web.context;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;

import java.io.IOException;


/**
 * @Description: Spring上下文配置 整合所有的配置信
 * @see: SpringRootConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:27:10
 * @author qinji.xu
 */
@Configuration
@EnableAspectJAutoProxy
@Import({MyBatisConfig.class,MariaDBConfig.class})
@ComponentScan(basePackages = "com.taotao", excludeFilters = { @Filter(Controller.class), @Filter(Configuration.class) })
public class SpringRootConfig {

}
