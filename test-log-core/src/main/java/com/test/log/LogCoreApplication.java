package com.test.log;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo(scanBasePackages={"com.test.log.service"})
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.test.log.dao")
@ComponentScan({"com.test.log", "test.log.config"})
public class LogCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogCoreApplication.class, args);
	}
    
}
