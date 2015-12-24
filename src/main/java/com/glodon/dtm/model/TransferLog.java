/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:40:04
 */
package com.glodon.dtm.model;

import java.io.Serializable;
import java.util.Date;

public class TransferLog implements Serializable {

	/** */
	private static final long serialVersionUID = -8129020285615188687L;

	private String pk;

	private Date startDate;

	private Date endDate;

	private Long costs;

	private Date createDate;

	private String successIds;

	private String failIds;

	private String failInfo;

	public static final String PK = "pk";

	public static final String STARTDATE = "startDate";

	public static final String ENDDATE = "endDate";

	public static final String COSTS = "costs";

	public static final String CREATEDATE = "createDate";

	public static final String SUCCESSIDS = "successIds";

	public static final String FAILIDS = "failIds";

	public static final String FAILINFO = "failInfo";

	public TransferLog() {
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

	public Long getCosts() {
		return costs;
	}

	public void setCosts(Long costs) {
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
