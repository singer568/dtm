/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:02:08
 */
package com.glodon.dtm.hd.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.glodon.dtm.common.util.DateUtil;
import com.glodon.dtm.hd.model.CZ_ExecPackage;
import com.glodon.dtm.hd.model.CZ_ExecuteNotice;
import com.glodon.dtm.hd.model.CZ_ExecuteNoticeDetail;
import com.glodon.dtm.hd.model.CZ_ExecuteNoticeTZ;
import com.glodon.dtm.hd.model.CZ_ResultPublicity;
import com.glodon.dtm.hd.model.HD_ExecPackage;
import com.glodon.dtm.hd.model.HD_ExecuteNotice;
import com.glodon.dtm.hd.model.HD_ExecuteNoticeDetail;
import com.glodon.dtm.hd.model.HD_ExecuteNoticeTZ;
import com.glodon.dtm.hd.model.HD_ResultPublicity;

public class DataConverter {

	public static List<HD_ExecuteNotice> convertDatas(List<CZ_ExecuteNotice> czs) {
		if (czs == null || czs.size() < 1) {
			return null;
		}
		List<HD_ExecuteNotice> lst = new ArrayList<HD_ExecuteNotice>();
		for (int i = 0; i < czs.size(); i++) {
			lst.add(convertOne(czs.get(i)));
		}

		return lst;
	}

	/**
	 * 招标办代理机构，采购方式，执行通知书编号，项目类别
	 * @param cz
	 * @return
	 */
	public static HD_ExecuteNoticeDetail convertOne(CZ_ExecuteNoticeDetail cz) {
		if (cz == null) {
			return null;
		}
		HD_ExecuteNoticeDetail hd = new HD_ExecuteNoticeDetail();
		hd.setCgmxid(cz.getCGMXID() + "");
		hd.setXmid(cz.getXMID().toString());
		hd.setItem_id(cz.getCGMXID() + "");
		hd.setExecute_notice_id(cz.getXMID() + "");
		hd.setCreate_date(new Date());
		hd.setProcurement_amount(cz.getCGJE());
		hd.setProcurement_detail(cz.getCGMX());
		hd.setProcurement_number(cz.getCGSL());
		return hd;
	}

	public static CZ_ExecPackage convertOne(HD_ExecPackage hd) {
		if (hd == null) {
			return null;
		}
		CZ_ExecPackage cz = new CZ_ExecPackage();
		cz.setExecute_notice_id(hd.getExecute_notice_id());
		cz.setPackage_id(hd.getPackage_id());
		cz.setProject_id(hd.getProject_id());
		cz.setXmid(hd.getXmid());
		return cz;
	}

	public static CZ_ResultPublicity convertOne(HD_ResultPublicity hd) {
		if (hd == null) {
			return null;
		}
		CZ_ResultPublicity cz = new CZ_ResultPublicity();
		cz.setBbid(hd.getBbid());
		cz.setCgxmfzr(hd.getCgxmfzr());
		cz.setFzrdh(hd.getFzrdh());
		cz.setFzrsj(hd.getFzrsj());
		cz.setLrr(hd.getLrr());
		cz.setLrsj(hd.getLrsj());
		cz.setSfbgcgfs(hd.getSfbgcgfs());
		cz.setShzt(new BigDecimal("0"));
		cz.setXmid(hd.getXmid());
		cz.setZbbh(hd.getZbbh());
		String dm = getTenderWayNum(hd.getZbcgfsdm());
		cz.setZbcgfsdm(dm == null ? null : new BigDecimal(dm));
		String name = getTenderWayName(dm);
		cz.setZbcgfsmc(name);
		cz.setZbdj(hd.getZbdj());
		cz.setZbgysmc(hd.getZbgysmc());
		cz.setZbje(hd.getZbje());
		cz.setZbrq(hd.getZbrq());

		return cz;
	}

	public static HD_ExecuteNoticeTZ convertOne(CZ_ExecuteNoticeTZ cz) {
		if (cz == null) {
			return null;
		}
		HD_ExecuteNoticeTZ hd = new HD_ExecuteNoticeTZ();
		hd.setChange_id(cz.getTZID() + "");
		hd.setExecute_notice_id(cz.getXMID() + "");
		hd.setXmid(cz.getXMID() + "");
		hd.setTzsx(cz.getTZSX());
		hd.setTzsm(cz.getTZSM());
		hd.setTzje(cz.getTZJE() + "");
		hd.setTzrq(cz.getTZRQ());
		hd.setTzcs(cz.getTZCS() + "");
		hd.setTzid(cz.getTZID() + "");
		return hd;
	}

	/**
	 * 招标办代理机构，采购方式，执行通知书编号，项目类别
	 * @param cz
	 * @return
	 */
	public static HD_ExecuteNotice convertOne(CZ_ExecuteNotice cz) {
		if (cz == null) {
			return null;
		}
		HD_ExecuteNotice hd = new HD_ExecuteNotice();
		hd.setXmid(cz.getXMID().toString());
		hd.setProcurement_unit_code(cz.getCGDWDM());
		hd.setProcurement_unit(cz.getCGDWMC());
		hd.setProject_name(cz.getCGXMMC());
		hd.setNotice_code(cz.getXMZXTZSBH());
		hd.setProject_amount(cz.getCGLXJE());
		hd.setBalance(cz.getCGLXJE());
		hd.setFinance_aid_amount(cz.getCZBZJE());
		hd.setFinance_special_amount(cz.getCZZHZJ());
		hd.setOther_amount(cz.getQTZJ());
		hd.setProject_category_code(cz.getXMLBDM() == null ? null : cz.getXMLBDM().toString());
		hd.setProject_category(cz.getXMLBMC());
		hd.setAdvance_item(cz.getSFYCX().toString());
		hd.setEquity(cz.getSFGZ().toString());
		hd.setMarket_bid(cz.getSFJWZB().toString());
		hd.setFloor_price(cz.getSFYDJ().toString());
		hd.setSingel_price(cz.getSFDJ().toString());
		hd.setQulifications(cz.getSFZZX().toString());
		hd.setImports(cz.getSFJKSP().toString());
		hd.setUnit_person(cz.getCGDWLXR());
		hd.setUnit_phone(cz.getCGDWLXDH());
		hd.setFinance_person(cz.getCZJLXR());
		hd.setFinance_phone(cz.getCZJLXDH());
		hd.setAgency_code(cz.getZBDLJGDM());
		hd.setAgency_name(cz.getZBDLJGMC());
		hd.setAgency_contact_person(cz.getZBDLLXR());
		hd.setEstablish_date(cz.getLXRQ());
		hd.setIs_cancel(cz.getSFZF().toString());
		hd.setTimestamp(cz.getSJ());
		hd.setCreate_date(DateUtil.getCurrentDate());
		hd.setTender_way(cz.getCGFSDM() == null ? null : getTenderWay(cz.getCGFSDM().toString()));
		hd.setExecute_notice_id(cz.getXMID().toString());
		hd.setRecord_status("COMMITTED");
		hd.setAgency_id("");
		hd.setOwner_id("");

		return hd;
	}

	private static String getTenderWay(String cz) {
		//1公开招标  2邀请招标  3竞争性谈判  4单一来源  5询价  6竞争性磋商  7其它
		//	GKZB("公开招标"), YQZB("邀请招标"), ZJFB("直接发包"), JZXTP("竞争性谈判"), DYLY("单一来源"), XJCG("询价采购"), WSXJ("网上询价"), CGK("采购卡"), ZXCG("自行采购"), WSXG("网上选购");

		String code = null;
		if ("1".equals(cz)) {
			code = "GKZB";
		}
		if ("2".equals(cz)) {
			code = "YQZB";
		}
		if ("3".equals(cz)) {
			code = "JZXTP";
		}
		if ("4".equals(cz)) {
			code = "DYLY";
		}
		if ("5".equals(cz)) {
			code = "XJCG";
		}
		if ("6".equals(cz)) {
			code = "JZXTP";
		}
		if ("7".equals(cz)) {
			code = "OTHER";
		}

		return code;
	}

	private static String getTenderWayNum(String hd) {
		//1公开招标  2邀请招标  3竞争性谈判  4单一来源  5询价  6竞争性磋商  7其它
		//	GKZB("公开招标"), YQZB("邀请招标"), ZJFB("直接发包"), JZXTP("竞争性谈判"), DYLY("单一来源"), XJCG("询价采购"), WSXJ("网上询价"), CGK("采购卡"), ZXCG("自行采购"), WSXG("网上选购");
		String code = null;
		if ("GKZB".equals(hd)) {
			code = "1";
		}
		if ("YQZB".equals(hd)) {
			code = "2";
		}
		if ("JZXTP".equals(hd)) {
			code = "3";
		}
		if ("DYLY".equals(hd)) {
			code = "4";
		}
		if ("XJCG".equals(hd)) {
			code = "5";
		}
		if ("JZXTP".equals(hd)) {
			code = "6";
		}
		if ("OTHER".equals(hd)) {
			code = "7";
		}
		return code;
	}

	private static String getTenderWayName(String cz) {

		String name = null;
		if ("1".equals(cz)) {
			name = "公开招标";
		}
		if ("2".equals(cz)) {
			name = "邀请招标";
		}
		if ("3".equals(cz)) {
			name = "竞争性谈判";
		}
		if ("4".equals(cz)) {
			name = "单一来源";
		}
		if ("5".equals(cz)) {
			name = "询价";
		}
		if ("6".equals(cz)) {
			name = "竞争性磋商";
		}
		if ("7".equals(cz)) {
			name = "其它";
		}
		return name;

	}

}
