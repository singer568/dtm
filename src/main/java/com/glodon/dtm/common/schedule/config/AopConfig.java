/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月24日 下午4:20:52
 */
package com.glodon.dtm.common.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.glodon.dtm.common.schedule.aop.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
	
	@Bean
	public LoggingAspect loggingAspect(){
		return new LoggingAspect();
	}
}
