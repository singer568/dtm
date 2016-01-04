/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:40:04
 */
package com.glodon.dtm.common.model;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

	/** */
	private static final long serialVersionUID = -8129020285615188687L;

	private String pk;

	private Date startDate;

	private String longStartDate;

	private Date endDate;

	private String longEndDate;

	private String costs;

	private Date createDate;

	private String allIds;

	private String allCount;

	private String successIds;

	private String successCount;

	private String failIds;

	private String failCount;

	private String failInfo;

	private String noIds;

	private String noCount;

	public static final String PK = "pk";

	public static final String STARTDATE = "startDate";

	public static final String ENDDATE = "endDate";

	public static final String SUCCESSCOUNT = "successCount";

	public static final String COSTS = "costs";

	public static final String CREATEDATE = "createDate";

	public static final String SUCCESSIDS = "successIds";

	public static final String FAILIDS = "failIds";

	public static final String FAILCOUNT = "failCount";

	public static final String FAILINFO = "failInfo";

	public static final String LONGSTARTDATE = "longStartDate";

	public static final String LONGENDDATE = "longEndDate";

	public static final String ALLIDS = "allIds";

	public static final String ALLCOUNT = "allCount";

	public static final String NOIDS = "noIds";

	public static final String NOCOUNT = "noCount";

	public Log() {
	}

	public String getAllCount() {
		return allCount;
	}

	public void setAllCount(String allCount) {
		this.allCount = allCount;
	}

	public String getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(String successCount) {
		this.successCount = successCount;
	}

	public String getFailCount() {
		return failCount;
	}

	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}

	public String getNoCount() {
		return noCount;
	}

	public void setNoCount(String noCount) {
		this.noCount = noCount;
	}

	public String getNoIds() {
		return noIds;
	}

	public void setNoIds(String noIds) {
		this.noIds = noIds;
	}

	public String getAllIds() {
		return allIds;
	}

	public void setAllIds(String allIds) {
		this.allIds = allIds;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLongStartDate() {
		return longStartDate;
	}

	public void setLongStartDate(String longStartDate) {
		this.longStartDate = longStartDate;
	}

	public String getLongEndDate() {
		return longEndDate;
	}

	public void setLongEndDate(String longEndDate) {
		this.longEndDate = longEndDate;
	}

	public String getCosts() {
		return costs;
	}

	public void setCosts(String costs) {
		this.costs = costs;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getSuccessIds() {
		return successIds;
	}

	public void setSuccessIds(String successIds) {
		this.successIds = successIds;
	}

	public String getFailIds() {
		return failIds;
	}

	public void setFailIds(String failIds) {
		this.failIds = failIds;
	}

	public String getFailInfo() {
		return failInfo;
	}

	public void setFailInfo(String failInfo) {
		this.failInfo = failInfo;
	}

}
