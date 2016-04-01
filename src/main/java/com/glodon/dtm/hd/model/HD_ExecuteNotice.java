/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HD_ExecuteNotice implements Serializable {

	/** */
	private static final long serialVersionUID = 2292429422276984898L;

	/** 执行通知书Id */
	private String execute_notice_id;

	/** 财政局项目主键 */
	private String xmid;

	/** 采购单位代码 */
	private String procurement_unit_code;

	/** 采购单位名称 */
	private String procurement_unit;

	/** 采购项目名称 */
	private String project_name;

	/** 通知书编号 */
	private String notice_code;

	/** 采购方式 */
	private String tender_way;

	/** 采购立项金额 */
	private BigDecimal project_amount;

	/** 剩余的采购立项金额 */
	private BigDecimal balance;

	/** 财政补助金额 */
	private BigDecimal finance_aid_amount;

	/** 财政专户金额 */
	private BigDecimal finance_special_amount;

	/** 其他资金 */
	private BigDecimal other_amount;

	/** 项目类别代码 */
	private String project_category_code;

	/** 项目类别名称 */
	private String project_category;

	/** 是否预采项, 是：1 否：0 */
	private String advance_item;

	/** 是否公正, 是：1 否：0 */
	private String equity;

	/** 是否在市建委有行市场招标, 是：1 否：0 */
	private String market_bid;

	/** 是否有低价, 是：1 否：0 */
	private String floor_price;

	/** 是否有单价, 是：1 否：0 */
	private String singel_price;

	/** 是否资质项, 是：1 否：0 */
	private String qulifications;

	/** 是否进口产品, 是：1 否：0 */
	private String imports;

	/** 采购单位联系人 */
	private String unit_person;

	/** 采购单位联系电话 */
	private String unit_phone;

	/** 财政局联系人 */
	private String finance_person;

	/** 财政局联系电话 */
	private String finance_phone;
	/** 财政局科室 */
	private String finance_ks;

	/** 采购代理机构名称 */
	private String agency_name;

	/** 采购代理机构编码 */
	private String agency_code;

	/** 采购代理机构Id */
	private String agency_id;

	/** 采购代理联系人 */
	private String agency_contact_person;

	/** 立项日期 */
	private Date establish_date;

	/** 是否作废是否作废 0 ：否；1：是 */
	private String is_cancel;

	/** 时间戳(财政那面的) */
	private Date timestamp;

	/** 创建日期或叫同步日期 */
	private Date create_date;

	private String owner_id;

	private String record_status;

	public HD_ExecuteNotice() {

	}

	public String getExecute_notice_id() {
		return execute_notice_id;
	}

	public void setExecute_notice_id(String execute_notice_id) {
		this.execute_notice_id = execute_notice_id;
	}

	
	public String getFinance_ks() {
		return finance_ks;
	}

	
	public void setFinance_ks(String finance_ks) {
		this.finance_ks = finance_ks;
	}

	public String getAdvance_item() {
		return advance_item;
	}

	public void setAdvance_item(String advance_item) {
		this.advance_item = advance_item;
	}

	public String getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(String agency_id) {
		this.agency_id = agency_id;
	}

	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getEquity() {
		return equity;
	}

	public void setEquity(String equity) {
		this.equity = equity;
	}

	public BigDecimal getFinance_aid_amount() {
		return finance_aid_amount;
	}

	public void setFinance_aid_amount(BigDecimal finance_aid_amount) {
		this.finance_aid_amount = finance_aid_amount;
	}

	public String getFinance_person() {
		return finance_person;
	}

	public void setFinance_person(String finance_person) {
		this.finance_person = finance_person;
	}

	public String getFinance_phone() {
		return finance_phone;
	}

	public void setFinance_phone(String finance_phone) {
		this.finance_phone = finance_phone;
	}

	public BigDecimal getFinance_special_amount() {
		return finance_special_amount;
	}

	public void setFinance_special_amount(BigDecimal finance_special_amount) {
		this.finance_special_amount = finance_special_amount;
	}

	public String getFloor_price() {
		return floor_price;
	}

	public void setFloor_price(String floor_price) {
		this.floor_price = floor_price;
	}

	public String getImports() {
		return imports;
	}

	public void setImports(String imports) {
		this.imports = imports;
	}

	public String getMarket_bid() {
		return market_bid;
	}

	public void setMarket_bid(String market_bid) {
		this.market_bid = market_bid;
	}

	public String getNotice_code() {
		return notice_code;
	}

	public void setNotice_code(String notice_code) {
		this.notice_code = notice_code;
	}

	public BigDecimal getOther_amount() {
		return other_amount;
	}

	public void setOther_amount(BigDecimal other_amount) {
		this.other_amount = other_amount;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getProcurement_unit() {
		return procurement_unit;
	}

	public void setProcurement_unit(String procurement_unit) {
		this.procurement_unit = procurement_unit;
	}

	public BigDecimal getProject_amount() {
		return project_amount;
	}

	public void setProject_amount(BigDecimal project_amount) {
		this.project_amount = project_amount;
	}

	public String getProject_category() {
		return project_category;
	}

	public void setProject_category(String project_category) {
		this.project_category = project_category;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getRecord_status() {
		return record_status;
	}

	public void setRecord_status(String record_status) {
		this.record_status = record_status;
	}

	public String getTender_way() {
		return tender_way;
	}

	public void setTender_way(String tender_way) {
		this.tender_way = tender_way;
	}

	public String getUnit_person() {
		return unit_person;
	}

	public void setUnit_person(String unit_person) {
		this.unit_person = unit_person;
	}

	public String getUnit_phone() {
		return unit_phone;
	}

	public void setUnit_phone(String unit_phone) {
		this.unit_phone = unit_phone;
	}

	public String getAgency_code() {
		return agency_code;
	}

	public void setAgency_code(String agency_code) {
		this.agency_code = agency_code;
	}

	public String getAgency_contact_person() {
		return agency_contact_person;
	}

	public void setAgency_contact_person(String agency_contact_person) {
		this.agency_contact_person = agency_contact_person;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getEstablish_date() {
		return establish_date;
	}

	public void setEstablish_date(Date establish_date) {
		this.establish_date = establish_date;
	}

	public String getIs_cancel() {
		return is_cancel;
	}

	public void setIs_cancel(String is_cancel) {
		this.is_cancel = is_cancel;
	}

	public String getProcurement_unit_code() {
		return procurement_unit_code;
	}

	public void setProcurement_unit_code(String procurement_unit_code) {
		this.procurement_unit_code = procurement_unit_code;
	}

	public String getProject_category_code() {
		return project_category_code;
	}

	public void setProject_category_code(String project_category_code) {
		this.project_category_code = project_category_code;
	}

	public String getQulifications() {
		return qulifications;
	}

	public void setQulifications(String qulifications) {
		this.qulifications = qulifications;
	}

	public String getSingel_price() {
		return singel_price;
	}

	public void setSingel_price(String singel_price) {
		this.singel_price = singel_price;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

}
