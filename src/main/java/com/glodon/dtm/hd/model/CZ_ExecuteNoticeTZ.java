/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CZ_ExecuteNoticeTZ implements Serializable {

	/** */
	private static final long serialVersionUID = -1375140403068025600L;

	/** 调整事项	 */
	private String TZSX;

	//调整说明
	private String TZSM;

	//调整金额
	private String TZJE;

	//调整日期
	private Date TZRQ;

	//调整次数
	private BigDecimal TZCS;

	//调整主键
	private BigDecimal TZID;

	//项目主键
	private BigDecimal XMID;
	
	/** 财政局联系人	　 */
	private String CZJLXR;

	/** 财政局联系电话	　 */
	private String CZJLXDH;
	

	public CZ_ExecuteNoticeTZ() {

	}

	public String getCZJLXR() {
		return CZJLXR;
	}

	
	public void setCZJLXR(String cZJLXR) {
		CZJLXR = cZJLXR;
	}

	
	public String getCZJLXDH() {
		return CZJLXDH;
	}

	
	public void setCZJLXDH(String cZJLXDH) {
		CZJLXDH = cZJLXDH;
	}

	public String getTZSX() {
		return TZSX;
	}

	public void setTZSX(String tZSX) {
		TZSX = tZSX;
	}

	public String getTZSM() {
		return TZSM;
	}

	public void setTZSM(String tZSM) {
		TZSM = tZSM;
	}

	public String getTZJE() {
		return TZJE;
	}

	public void setTZJE(String tZJE) {
		TZJE = tZJE;
	}

	public Date getTZRQ() {
		return TZRQ;
	}

	public void setTZRQ(Date tZRQ) {
		TZRQ = tZRQ;
	}

	public BigDecimal getTZCS() {
		return TZCS;
	}

	public void setTZCS(BigDecimal tZCS) {
		TZCS = tZCS;
	}

	public BigDecimal getTZID() {
		return TZID;
	}

	public void setTZID(BigDecimal tZID) {
		TZID = tZID;
	}

	public BigDecimal getXMID() {
		return XMID;
	}

	public void setXMID(BigDecimal xMID) {
		XMID = xMID;
	}

}
