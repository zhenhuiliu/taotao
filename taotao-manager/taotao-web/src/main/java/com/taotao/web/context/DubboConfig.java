package com.taotao.web.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * @Description: dubbo基础配置
 * @see: DubboConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:21:05
 * @author qinji.xu
 */
@Configuration
@PropertySource("classpath:/dubbo.properties")
public class DubboConfig {

    @Value("${dubbo.appName}")
    private String appName;

    @Value("${dubbo.resAddress}")
    private String resAddress;

	/*@Value("${dubbo.resUsername}")
	private String resUsername;

	@Value("${dubbo.resPassowrd}")
	private String resPassowrd;*/

    @Value("${dubbo.protocol}")
    private String protocol;

    @Value("${dubbo.port}")
    private int port;

    @Value("${dubbo.monAddress}")
    private String monAddress;

    @Value("${dubbo.connections}")
    private int connections;

    @Bean
    public ApplicationConfig application() {
        ApplicationConfig applicationConfig = new ApplicationConfig(appName);
        applicationConfig.setMonitor(monitor());
        applicationConfig.setRegistry(registry());
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registry() {
        RegistryConfig registryConfig = new RegistryConfig(resAddress);
        //registryConfig.setUsername(resUsername);
        //registryConfig.setPassword(resPassowrd);
        registryConfig.setProtocol(protocol);
        registryConfig.setPort(port);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocol() {
        ProtocolConfig protocolConfig = new ProtocolConfig(protocol, port);
        return protocolConfig;
    }

    @Bean
    public MonitorConfig monitor() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    @Bean
    public ProviderConfig provider() {
        ProviderConfig config = new ProviderConfig();
        config.setConnections(connections);
        return config;
    }
}
