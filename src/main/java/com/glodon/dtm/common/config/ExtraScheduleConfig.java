/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月30日 上午9:47:03
 */
package com.glodon.dtm.common.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.glodon.dtm.common.util.DateUtil;

@ConfigurationProperties(prefix = "extra.schedule")
public class ExtraScheduleConfig {

	/** 取数频率 */
	private String cron;

	private String startDate;

	private String endDate;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {

		return endDate;
	}

	public Date getDateEnd() {
		if (endDate == null || "".equals(endDate.trim())) {
			return DateUtil.getBeginDate();
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Date getDateBegin() {
		if (startDate == null || "".equals(startDate.trim())) {
			return DateUtil.getEndDate();
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
