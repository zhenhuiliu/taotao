package com.taotao.web.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dubbo-client.xml")
public class DubboClientConfig {
}
