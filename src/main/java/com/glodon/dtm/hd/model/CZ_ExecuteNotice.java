/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:35:21
 */
package com.glodon.dtm.hd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CZ_ExecuteNotice implements Serializable {

	/** */
	private static final long serialVersionUID = 3459278705777463355L;

	/** 项目主键	 */
	private BigDecimal XMID;

	/** 采购单位代码	 */
	private String CGDWDM;

	/** 采购单位名称	 */
	private String CGDWMC;

	/** 采购项目名称	　 */
	private String CGXMMC;

	/** 项目执行通知书编号 */
	private String XMZXTZSBH;

	/** 采购方式代码	1公开招标  2邀请招标  3竞争性谈判  4单一来源  5询价  6竞争性磋商  7其它 */
	private BigDecimal CGFSDM;

	/** 采购方式名称	1公开招标  2邀请招标  3竞争性谈判  4单一来源  5询价  6竞争性磋商  7其它 */
	private String CGFSMC;

	/** 采购立项金额	　 */
	private BigDecimal CGLXJE;

	/** 财政补助金额	　 */
	private BigDecimal CZBZJE;

	/** 财政专户资金	　 */
	private BigDecimal CZZHZJ;

	/** 其他资金	　 */
	private BigDecimal QTZJ;

	/** 项目类别代码	1工程 2服务 3货物 */
	private BigDecimal XMLBDM;

	/** 项目类别名称	1工程 2服务 3货物 */
	private String XMLBMC;

	/**是否预采项	0否1是 */
	private BigDecimal SFYCX;

	/** 是否公正	0否1是  */
	private BigDecimal SFGZ;

	/** 是否建委招标	0否1是 */
	private BigDecimal SFJWZB;

	/** 是否有低价	0否1是 */
	private BigDecimal SFYDJ;

	/** 是否单价	0否1是 */
	private BigDecimal SFDJ;

	/** 是否资质项	0否1是 */
	private BigDecimal SFZZX;

	/** 是否进口商品	0否1是 */
	private BigDecimal SFJKSP;

	/** 采购单位联系人	　 */
	private String CGDWLXR;

	/** 采购单位联系电话	　 */
	private String CGDWLXDH;

	/** 财政局联系人	　 */
	private String CZJLXR;

	/** 财政局联系电话	　 */
	private String CZJLXDH;

	/** 招标代理机构代码	　 */
	private String ZBDLJGDM;

	/** 招标代理机构名称	　 */
	private String ZBDLJGMC;

	/** 招标代理联系人	　 */
	private String ZBDLLXR;

	/** 立项日期 */
	private Date LXRQ;

	/** 是否作废	0否1是 */
	private BigDecimal SFZF;

	/** 时间戳	　 */
	private Date SJ;

	public CZ_ExecuteNotice() {

	}

	public BigDecimal getXMID() {
		return XMID;
	}

	public void setXMID(BigDecimal xMID) {
		XMID = xMID;
	}

	public String getCGDWDM() {
		return CGDWDM;
	}

	public void setCGDWDM(String cGDWDM) {
		CGDWDM = cGDWDM;
	}

	public String getCGDWMC() {
		return CGDWMC;
	}

	public void setCGDWMC(String cGDWMC) {
		CGDWMC = cGDWMC;
	}

	public String getCGXMMC() {
		return CGXMMC;
	}

	public void setCGXMMC(String cGXMMC) {
		CGXMMC = cGXMMC;
	}

	public String getXMZXTZSBH() {
		return XMZXTZSBH;
	}

	public void setXMZXTZSBH(String xMZXTZSBH) {
		XMZXTZSBH = xMZXTZSBH;
	}

	public BigDecimal getCGFSDM() {
		return CGFSDM;
	}

	public void setCGFSDM(BigDecimal cGFSDM) {
		CGFSDM = cGFSDM;
	}

	public String getCGFSMC() {
		return CGFSMC;
	}

	public void setCGFSMC(String cGFSMC) {
		CGFSMC = cGFSMC;
	}

	public BigDecimal getCGLXJE() {
		return CGLXJE;
	}

	public void setCGLXJE(BigDecimal cGLXJE) {
		CGLXJE = cGLXJE;
	}

	public BigDecimal getCZBZJE() {
		return CZBZJE;
	}

	public void setCZBZJE(BigDecimal cZBZJE) {
		CZBZJE = cZBZJE;
	}

	public BigDecimal getCZZHZJ() {
		return CZZHZJ;
	}

	public void setCZZHZJ(BigDecimal cZZHZJ) {
		CZZHZJ = cZZHZJ;
	}

	public BigDecimal getQTZJ() {
		return QTZJ;
	}

	public void setQTZJ(BigDecimal qTZJ) {
		QTZJ = qTZJ;
	}

	public BigDecimal getXMLBDM() {
		return XMLBDM;
	}

	public void setXMLBDM(BigDecimal xMLBDM) {
		XMLBDM = xMLBDM;
	}

	public String getXMLBMC() {
		return XMLBMC;
	}

	public void setXMLBMC(String xMLBMC) {
		XMLBMC = xMLBMC;
	}

	public BigDecimal getSFYCX() {
		return SFYCX;
	}

	public void setSFYCX(BigDecimal sFYCX) {
		SFYCX = sFYCX;
	}

	public BigDecimal getSFGZ() {
		return SFGZ;
	}

	public void setSFGZ(BigDecimal sFGZ) {
		SFGZ = sFGZ;
	}

	public BigDecimal getSFJWZB() {
		return SFJWZB;
	}

	public void setSFJWZB(BigDecimal sFJWZB) {
		SFJWZB = sFJWZB;
	}

	public BigDecimal getSFYDJ() {
		return SFYDJ;
	}

	public void setSFYDJ(BigDecimal sFYDJ) {
		SFYDJ = sFYDJ;
	}

	public BigDecimal getSFDJ() {
		return SFDJ;
	}

	public void setSFDJ(BigDecimal sFDJ) {
		SFDJ = sFDJ;
	}

	public BigDecimal getSFZZX() {
		return SFZZX;
	}

	public void setSFZZX(BigDecimal sFZZX) {
		SFZZX = sFZZX;
	}

	public BigDecimal getSFJKSP() {
		return SFJKSP;
	}

	public void setSFJKSP(BigDecimal sFJKSP) {
		SFJKSP = sFJKSP;
	}

	public String getCGDWLXR() {
		return CGDWLXR;
	}

	public void setCGDWLXR(String cGDWLXR) {
		CGDWLXR = cGDWLXR;
	}

	public String getCGDWLXDH() {
		return CGDWLXDH;
	}

	public void setCGDWLXDH(String cGDWLXDH) {
		CGDWLXDH = cGDWLXDH;
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

	public String getZBDLJGDM() {
		return ZBDLJGDM;
	}

	public void setZBDLJGDM(String zBDLJGDM) {
		ZBDLJGDM = zBDLJGDM;
	}

	public String getZBDLJGMC() {
		return ZBDLJGMC;
	}

	public void setZBDLJGMC(String zBDLJGMC) {
		ZBDLJGMC = zBDLJGMC;
	}

	public String getZBDLLXR() {
		return ZBDLLXR;
	}

	public void setZBDLLXR(String zBDLLXR) {
		ZBDLLXR = zBDLLXR;
	}

	public Date getLXRQ() {
		return LXRQ;
	}

	public void setLXRQ(Date lXRQ) {
		LXRQ = lXRQ;
	}

	public BigDecimal getSFZF() {
		return SFZF;
	}

	public void setSFZF(BigDecimal sFZF) {
		SFZF = sFZF;
	}

	public Date getSJ() {
		return SJ;
	}

	public void setSJ(Date sJ) {
		SJ = sJ;
	}

}
