package com.glodon.dtm.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatasourceConfig {

	@Bean(name = "jdbcPrimaryTemplate")
	public JdbcTemplate jdbcPrimaryTemplate(@Qualifier(value = "primaryDataSource") DataSource primaryDataSource) {
		return new JdbcTemplate(primaryDataSource);
	}

	@Bean(name = "jdbcSecondaryTemplate")
	public JdbcTemplate jdbcSecondaryTemplate(@Qualifier(value = "secondaryDataSource") DataSource secondaryDataSource) {
		return new JdbcTemplate(secondaryDataSource);
	}

	@Bean(name = "jdbcThirdTemplate")
	public JdbcTemplate jdbcThirdTemplate(@Qualifier(value = "thirdDataSource") DataSource secondaryDataSource) {
		return new JdbcTemplate(secondaryDataSource);
	}

	@Bean(name = "primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "datasource.primary")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix = "datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "thirdDataSource")
	@ConfigurationProperties(prefix = "datasource.third")
	public DataSource thirdDataSource() {
		return DataSourceBuilder.create().build();
	}

}
