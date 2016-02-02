/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月30日 上午9:47:03
 */
package com.glodon.dtm.hd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.glodon.dtm.common.util.DateUtil;

@ConfigurationProperties(prefix = "extra.schedule")
public class ExtraScheduleConfig {

	/** 执行通知书取数频率 */
	private String noticeCron;

	private String noticeJobName;

	private String noticeGroupName;

	private String noticeStartDate;

	private String noticeEndDate;

	/** 中标结果抓取频率 */
	private String publicityCron;

	private String publicityJobName;

	private String publicityGroupName;

	private String publicityStartDate;

	private String publicityEndDate;

	/** 执行通知书 标段抓取频率 */
	private String execPackageCron;

	private String execPackageJobName;

	private String execPackageGroupName;

	private String execPackageStartDate;

	private String execPackageEndDate;

	public String getNoticeCron() {
		return noticeCron;
	}

	public void setNoticeCron(String noticeCron) {
		this.noticeCron = noticeCron;
	}

	public String getNoticeJobName() {
		return noticeJobName;
	}

	public void setNoticeJobName(String noticeJobName) {
		this.noticeJobName = noticeJobName;
	}

	public String getNoticeGroupName() {
		return noticeGroupName;
	}

	public void setNoticeGroupName(String noticeGroupName) {
		this.noticeGroupName = noticeGroupName;
	}

	public String getNoticeStartDate() {
		return noticeStartDate;
	}

	public void setNoticeStartDate(String noticeStartDate) {
		this.noticeStartDate = noticeStartDate;
	}

	public String getNoticeEndDate() {
		return noticeEndDate;
	}

	public void setNoticeEndDate(String noticeEndDate) {
		this.noticeEndDate = noticeEndDate;
	}

	public String getPublicityCron() {
		return publicityCron;
	}

	public void setPublicityCron(String publicityCron) {
		this.publicityCron = publicityCron;
	}

	public String getPublicityJobName() {
		return publicityJobName;
	}

	public void setPublicityJobName(String publicityJobName) {
		this.publicityJobName = publicityJobName;
	}

	public String getPublicityGroupName() {
		return publicityGroupName;
	}

	public void setPublicityGroupName(String publicityGroupName) {
		this.publicityGroupName = publicityGroupName;
	}

	public String getPublicityStartDate() {
		return publicityStartDate;
	}

	public void setPublicityStartDate(String publicityStartDate) {
		this.publicityStartDate = publicityStartDate;
	}

	public String getPublicityEndDate() {
		return publicityEndDate;
	}

	public void setPublicityEndDate(String publicityEndDate) {
		this.publicityEndDate = publicityEndDate;
	}

	public String getExecPackageCron() {
		return execPackageCron;
	}

	public void setExecPackageCron(String execPackageCron) {
		this.execPackageCron = execPackageCron;
	}

	public String getExecPackageJobName() {
		return execPackageJobName;
	}

	public void setExecPackageJobName(String execPackageJobName) {
		this.execPackageJobName = execPackageJobName;
	}

	public String getExecPackageGroupName() {
		return execPackageGroupName;
	}

	public void setExecPackageGroupName(String execPackageGroupName) {
		this.execPackageGroupName = execPackageGroupName;
	}

	public String getExecPackageStartDate() {
		return execPackageStartDate;
	}

	public void setExecPackageStartDate(String execPackageStartDate) {
		this.execPackageStartDate = execPackageStartDate;
	}

	public String getExecPackageEndDate() {
		return execPackageEndDate;
	}

	public void setExecPackageEndDate(String execPackageEndDate) {
		this.execPackageEndDate = execPackageEndDate;
	}

	public Date getStartDate(String startDate) {
		if (startDate == null || "".equals(startDate.trim())) {
			return DateUtil.getBeginDate();
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Date getEndDate(String endDate) {
		if (endDate == null || "".equals(endDate.trim())) {
			return DateUtil.getEndDate();
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
