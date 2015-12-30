/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月30日 上午9:47:03
 */
package com.glodon.dtm.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "extra.schedule")
public class ExtraScheduleConfig {

	/** 取数频率 */
	private String cron;

	/** 查询条件 */
	private String condition;

	private String job;

	private String group;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
