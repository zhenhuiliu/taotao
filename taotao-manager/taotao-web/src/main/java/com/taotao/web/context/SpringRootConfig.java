package com.taotao.web.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
@ComponentScan(basePackages = "com.taotao.web", excludeFilters = { @Filter(Controller.class), @Filter(Configuration.class) })
public class SpringRootConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}


	/**
	 *
	 * @return
	 * @throws IOException
	 */
	@Bean
	public ResourcePropertySource peripheralUrisProperties() throws IOException {
		return new ResourcePropertySource("classpath:/system.properties");
	}

}
