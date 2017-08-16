package com.taotao.web.context;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * @Description: MariaDB数据源配置
 * @see: MariaDBConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:22:10
 * @author qinji.xu
 */
@Configuration
@PropertySource("classpath:/db.properties")
public class MariaDBConfig {

	private static final Logger logger = LoggerFactory.getLogger(MariaDBConfig.class);

	@Value("${driver}")
	private String driverClass;
	
	@Value("${url}")
	private String jdbcUrl;
	
	@Value("${jdcbUserName}")
	private String userName;
	
	@Value("${password}")
	private String password;
	
	@Value("${initialSize}")
	private String initialSize;
	
	@Value("${maxActive}")
	private String maxActive;
	
	@Value("${maxIdle}")
	private String maxIdle;
	
	@Value("${minIdle}")
	private String minIdle;
	
	@Value("${maxWait}")
	private String maxWait;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws PropertyVetoException {
		long l = System.currentTimeMillis();
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(driverClass);
		ds.setJdbcUrl(jdbcUrl);
		ds.setUser(userName);
		ds.setPassword(password);
		return ds;
	}

}
