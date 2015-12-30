package com.glodon.dtm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.glodon.dtm.common.config.ExtraScheduleConfig;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableConfigurationProperties(ExtraScheduleConfig.class)
public class Application {

	public static void main(String... args) {
		SpringApplication.run(Application.class);
	}
}
