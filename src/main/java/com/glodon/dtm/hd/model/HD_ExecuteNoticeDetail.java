/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HD_ExecuteNoticeDetail implements Serializable {

	/** */
	private static final long serialVersionUID = 2292429422276984898L;

	/** 明细主键 */
	private String item_id;

	/** 执行通知书主键 */
	private String execute_notice_id;

	private Date create_date;

	/** 采购金额 */
	private BigDecimal procurement_amount;

	/** 采购明细 */
	private String procurement_detail;

	/** 采购数量 */
	private BigDecimal procurement_number;

	/** 采购明细主键 */
	private String cgmxid;

	/** 执行通知书主键 */
	private String xmid;

	public HD_ExecuteNoticeDetail() {

	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getExecute_notice_id() {
		return execute_notice_id;
	}

	public void setExecute_notice_id(String execute_notice_id) {
		this.execute_notice_id = execute_notice_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public BigDecimal getProcurement_amount() {
		return procurement_amount;
	}

	public void setProcurement_amount(BigDecimal procurement_amount) {
		this.procurement_amount = procurement_amount;
	}

	public String getProcurement_detail() {
		return procurement_detail;
	}

	public void setProcurement_detail(String procurement_detail) {
		this.procurement_detail = procurement_detail;
	}

	public BigDecimal getProcurement_number() {
		return procurement_number;
	}

	public void setProcurement_number(BigDecimal procurement_number) {
		this.procurement_number = procurement_number;
	}

	public String getCgmxid() {
		return cgmxid;
	}

	public void setCgmxid(String cgmxid) {
		this.cgmxid = cgmxid;
	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

}
