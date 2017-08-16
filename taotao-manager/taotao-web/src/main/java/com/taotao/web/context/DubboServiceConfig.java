package com.taotao.web.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dubbo-service.xml")
public class DubboServiceConfig {
}
