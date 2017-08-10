package com.taotao.web.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * @Description: Spring MVC配置
 * @see: SpringMVCConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:25:13
 * @author qinji.xu
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.taotao.web.web", useDefaultFilters = false, includeFilters = @Filter(Controller.class) )
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter adapter = new org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter();

		List<MediaType> mediaList = new ArrayList<MediaType>();
		mediaList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
		mediaList.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
		mediaList.add(new MediaType("text", "html", Charset.forName("UTF-8")));
		mediaList.add(new MediaType("text", "xml", Charset.forName("UTF-8")));

		StringHttpMessageConverter stringHttpMessageConverter = new org.springframework.http.converter.StringHttpMessageConverter();
		stringHttpMessageConverter.setSupportedMediaTypes(mediaList);

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new org.springframework.http.converter.json.MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaList);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(stringHttpMessageConverter);
		messageConverters.add(mappingJackson2HttpMessageConverter);

		adapter.setMessageConverters(messageConverters);
		return adapter;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/images/**").addResourceLocations("/images/**");
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setDefaultErrorView("error/error");
		return exceptionResolver;
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(simpleMappingExceptionResolver());
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}

	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		simpleUrlHandlerMapping.setMappings(mappings);
		return simpleUrlHandlerMapping;
	}
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// http前置请求拦截器
		//registry.addInterceptor(new CommonHttpRequestInterceptor()).addPathPatterns("/**")
		//		.excludePathPatterns("/notify/recommender/memberWeixinpayNotify");
		// 公共参数拦截器
		//registry.addInterceptor(new ValidateInterceptor()).addPathPatterns("/**").excludePathPatterns("/web/**");
		super.addInterceptors(registry);
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver() {

		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		// commonsMultipartResolver.setMaxUploadSize(30*1024*1024);
		return commonsMultipartResolver;
	}
}
