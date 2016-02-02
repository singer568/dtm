/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.util.Date;

public class HD_ExecuteNoticeTZ implements Serializable {

	/** */
	private static final long serialVersionUID = 2292429422276984898L;

	/** 明细主键 */
	private String change_id;

	/** 执行通知书主键 */
	private String execute_notice_id;

	/** 执行通知书主键 */
	private String xmid;

	//"调整事项")
	private String tzsx;

	//"调整说明")
	private String tzsm;

	//"调整金额")
	private String tzje;

	//"调整日期")
	private Date tzrq;

	//"调整次数")
	private String tzcs;

	//"调整主键")
	private String tzid;

	public HD_ExecuteNoticeTZ() {

	}

	public String getChange_id() {
		return change_id;
	}

	public void setChange_id(String change_id) {
		this.change_id = change_id;
	}

	public String getExecute_notice_id() {
		return execute_notice_id;
	}

	public void setExecute_notice_id(String execute_notice_id) {
		this.execute_notice_id = execute_notice_id;
	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getTzsx() {
		return tzsx;
	}

	public void setTzsx(String tzsx) {
		this.tzsx = tzsx;
	}

	public String getTzsm() {
		return tzsm;
	}

	public void setTzsm(String tzsm) {
		this.tzsm = tzsm;
	}

	
	public String getTzje() {
		return tzje;
	}

	
	public void setTzje(String tzje) {
		this.tzje = tzje;
	}

	public Date getTzrq() {
		return tzrq;
	}

	public void setTzrq(Date tzrq) {
		this.tzrq = tzrq;
	}

	public String getTzcs() {
		return tzcs;
	}

	public void setTzcs(String tzcs) {
		this.tzcs = tzcs;
	}

	public String getTzid() {
		return tzid;
	}

	public void setTzid(String tzid) {
		this.tzid = tzid;
	}

}
