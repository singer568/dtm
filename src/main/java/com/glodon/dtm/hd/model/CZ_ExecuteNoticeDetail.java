/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CZ_ExecuteNoticeDetail implements Serializable {

	/** */
	private static final long serialVersionUID = 3459278705777463355L;

	/** 项目主键	 */
	private BigDecimal XMID;

	/** 采购明细主键 */
	private BigDecimal CGMXID;

	/** 采购立项金额	　 */
	private BigDecimal CGJE;

	/** 采购数量 */
	private BigDecimal CGSL;

	/** 采购明细	 */
	private String CGMX;

	public CZ_ExecuteNoticeDetail() {

	}

	public BigDecimal getXMID() {
		return XMID;
	}

	public void setXMID(BigDecimal xMID) {
		XMID = xMID;
	}

	public BigDecimal getCGMXID() {
		return CGMXID;
	}

	public void setCGMXID(BigDecimal cGMXID) {
		CGMXID = cGMXID;
	}

	public BigDecimal getCGJE() {
		return CGJE;
	}

	public void setCGJE(BigDecimal cGJE) {
		CGJE = cGJE;
	}

	public BigDecimal getCGSL() {
		return CGSL;
	}

	public void setCGSL(BigDecimal cGSL) {
		CGSL = cGSL;
	}

	public String getCGMX() {
		return CGMX;
	}

	public void setCGMX(String cGMX) {
		CGMX = cGMX;
	}

}
