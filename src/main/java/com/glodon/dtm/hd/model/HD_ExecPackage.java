/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class HD_ExecPackage implements Serializable {

	/** */
	private static final long serialVersionUID = 2292429422276984898L;

	/** 明细主键 */
	private String project_id;

	private BigDecimal xmid;

	private String execute_notice_id;

	private String package_id;

	public HD_ExecPackage() {

	}

	public String getPackage_id() {
		return package_id;
	}

	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public BigDecimal getXmid() {
		return xmid;
	}

	public void setXmid(BigDecimal xmid) {
		this.xmid = xmid;
	}

	public String getExecute_notice_id() {
		return execute_notice_id;
	}

	public void setExecute_notice_id(String execute_notice_id) {
		this.execute_notice_id = execute_notice_id;
	}

}
