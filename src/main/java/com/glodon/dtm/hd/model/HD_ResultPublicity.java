/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HD_ResultPublicity implements Serializable {

	/** */
	private static final long serialVersionUID = 2292429422276984898L;

	/** 项目主键	 */
	private String xmid;

	//标包主键
	private String bbid;

	//审核状态 1
	private String shzt;

	/** 录入时间 */
	private Date lrsj;

	/** 录入人 */
	private String lrr;

	//中标供应商名称
	private String zbgysmc;

	//中标日期
	private Date zbrq;

	//中标单价
	private BigDecimal zbdj;

	//中标金额
	private BigDecimal zbje;

	//负责人手机
	private String fzrsj;

	//负责人电话
	private String fzrdh;

	//采购项目负责人
	private String cgxmfzr;

	//招标编号
	private String zbbh;

	//中标采购方式名称
	private String zbcgfsmc;

	//中标采购方式代码
	private String zbcgfsdm;

	//是否变更采购方式
	private BigDecimal sfbgcgfs;

	public HD_ResultPublicity() {

	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getShzt() {
		return shzt;
	}

	public void setShzt(String shzt) {
		this.shzt = shzt;
	}

	public String getZbcgfsdm() {
		return zbcgfsdm;
	}

	public void setZbcgfsdm(String zbcgfsdm) {
		this.zbcgfsdm = zbcgfsdm;
	}

	public String getBbid() {
		return bbid;
	}

	public void setBbid(String bbid) {
		this.bbid = bbid;
	}

	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	public String getZbgysmc() {
		return zbgysmc;
	}

	public void setZbgysmc(String zbgysmc) {
		this.zbgysmc = zbgysmc;
	}

	public Date getZbrq() {
		return zbrq;
	}

	public void setZbrq(Date zbrq) {
		this.zbrq = zbrq;
	}

	public BigDecimal getZbdj() {
		return zbdj;
	}

	public void setZbdj(BigDecimal zbdj) {
		this.zbdj = zbdj;
	}

	public BigDecimal getZbje() {
		return zbje;
	}

	public void setZbje(BigDecimal zbje) {
		this.zbje = zbje;
	}

	public String getFzrsj() {
		return fzrsj;
	}

	public void setFzrsj(String fzrsj) {
		this.fzrsj = fzrsj;
	}

	public String getFzrdh() {
		return fzrdh;
	}

	public void setFzrdh(String fzrdh) {
		this.fzrdh = fzrdh;
	}

	public String getCgxmfzr() {
		return cgxmfzr;
	}

	public void setCgxmfzr(String cgxmfzr) {
		this.cgxmfzr = cgxmfzr;
	}

	public String getZbbh() {
		return zbbh;
	}

	public void setZbbh(String zbbh) {
		this.zbbh = zbbh;
	}

	public String getZbcgfsmc() {
		return zbcgfsmc;
	}

	public void setZbcgfsmc(String zbcgfsmc) {
		this.zbcgfsmc = zbcgfsmc;
	}

	public BigDecimal getSfbgcgfs() {
		return sfbgcgfs;
	}

	public void setSfbgcgfs(BigDecimal sfbgcgfs) {
		this.sfbgcgfs = sfbgcgfs;
	}

}
