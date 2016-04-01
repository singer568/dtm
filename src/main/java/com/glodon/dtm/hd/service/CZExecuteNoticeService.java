/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:13:23
 */
package com.glodon.dtm.hd.service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.glodon.dtm.common.util.DateUtil;
import com.glodon.dtm.hd.model.CZ_ExecuteNotice;
import com.glodon.dtm.hd.model.CZ_ExecuteNoticeDetail;
import com.glodon.dtm.hd.model.CZ_ExecuteNoticeTZ;

@Repository
public class CZExecuteNoticeService {

	@Autowired
	@Qualifier("jdbcSecondaryTemplate")
	private JdbcTemplate jdbcSecondaryTemplate;

	public CZ_ExecuteNotice findOne(String pk) {
		List<CZ_ExecuteNotice> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx WHERE XMID=?",
				new BigDecimal[] { new BigDecimal(pk) }, new CZExecuteNoticeMapper());
		if (notices == null || notices.size() < 1) {
			return null;
		}
		return notices.get(0);
	}

	public List<CZ_ExecuteNotice> findDatePair(Date startDate, Date endDate) {
		List<CZ_ExecuteNotice> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx where SZBSJ>=? and SZBSJ<=?", new Date[] {
				startDate, endDate }, new CZExecuteNoticeMapper());

		return notices;
	}

	public List<CZ_ExecuteNotice> findCurrentDay() {
		List<CZ_ExecuteNotice> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx where SZBSJ>=? and SZBSJ<=?",
				new Date[] { DateUtil.getBeginDate(), DateUtil.getEndDate() }, new CZExecuteNoticeMapper());

		return notices;
	}

	public List<CZ_ExecuteNotice> findAll() {
		List<CZ_ExecuteNotice> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx", new CZExecuteNoticeMapper());

		return notices;
	}

	public List<CZ_ExecuteNoticeDetail> findDetailByXMID(BigDecimal XMID) {
		List<CZ_ExecuteNoticeDetail> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx_cgmx where XMID=?",
				new BigDecimal[] { XMID }, new CZExecuteNoticeDetailMapper());

		return notices;
	}

	public List<CZ_ExecuteNoticeTZ> findTZByXMID(BigDecimal XMID) {
		List<CZ_ExecuteNoticeTZ> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx_tz where XMID=?", new BigDecimal[] { XMID },
				new CZ_ExecuteNoticeTZMapper());

		return notices;
	}

	private class CZExecuteNoticeMapper implements RowMapper<CZ_ExecuteNotice> {

		public CZ_ExecuteNotice mapRow(ResultSet rs, int rowNum) throws SQLException {
			CZ_ExecuteNotice notice = new CZ_ExecuteNotice();
			notice.setXMID(rs.getBigDecimal("XMID"));
			notice.setCGDWDM(rs.getString("CGDWDM"));
			notice.setCGDWMC(rs.getString("CGDWMC"));
			notice.setCGXMMC(rs.getString("CGXMMC"));
			notice.setXMZXTZSBH(rs.getString("XMZXTZSBH"));
			notice.setCGFSDM(rs.getBigDecimal("CGFSDM"));
			notice.setCGFSMC(rs.getString("CGFSMC"));
			notice.setCGLXJE(rs.getBigDecimal("CGLXJE"));
			notice.setCZBZJE(rs.getBigDecimal("CZBZJE"));
			notice.setCZZHZJ(rs.getBigDecimal("CZZHZJ"));
			notice.setQTZJ(rs.getBigDecimal("QTZJ"));
			notice.setXMLBDM(rs.getBigDecimal("XMLBDM"));
			notice.setXMLBMC(rs.getString("XMLBMC"));
			notice.setSFYCX(rs.getBigDecimal("SFYCX"));
			notice.setSFGZ(rs.getBigDecimal("SFGZ"));
			notice.setSFJWZB(rs.getBigDecimal("SFJWZB"));
			notice.setSFYDJ(rs.getBigDecimal("SFYDJ"));
			notice.setSFDJ(rs.getBigDecimal("SFDJ"));
			notice.setSFZZX(rs.getBigDecimal("SFZZX"));
			notice.setSFJKSP(rs.getBigDecimal("SFJKSP"));
			notice.setCGDWLXR(rs.getString("CGDWLXR"));
			notice.setCGDWLXDH(rs.getString("CGDWLXDH"));
			notice.setCZJLXR(rs.getString("CZJLXR"));
			notice.setCZJLXDH(rs.getString("CZJLXDH"));
			notice.setZBDLJGDM(rs.getString("ZBDLJGDM"));
			notice.setZBDLJGMC(rs.getString("ZBDLJGMC"));
			notice.setZBDLLXR(rs.getString("ZBDLLXR"));
			notice.setLXRQ(rs.getDate("LXRQ"));
			notice.setSFZF(rs.getBigDecimal("SFZF"));
			notice.setSJ(rs.getDate("SJ"));
			notice.setCZJKS(rs.getString("CZJKS"));
			return notice;
		}

	}

	private class CZExecuteNoticeDetailMapper implements RowMapper<CZ_ExecuteNoticeDetail> {

		public CZ_ExecuteNoticeDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			CZ_ExecuteNoticeDetail notice = new CZ_ExecuteNoticeDetail();
			notice.setXMID(rs.getBigDecimal("XMID"));
			notice.setCGMXID(rs.getBigDecimal("CGMXID"));
			notice.setCGJE(rs.getBigDecimal("CGJE"));
			notice.setCGSL(rs.getBigDecimal("CGSL"));
			notice.setCGMX(rs.getString("CGMX"));
			return notice;
		}
	}

	private class CZ_ExecuteNoticeTZMapper implements RowMapper<CZ_ExecuteNoticeTZ> {

		public CZ_ExecuteNoticeTZ mapRow(ResultSet rs, int rowNum) throws SQLException {
			CZ_ExecuteNoticeTZ notice = new CZ_ExecuteNoticeTZ();
			notice.setXMID(rs.getBigDecimal("XMID"));
			notice.setTZSX(rs.getString("TZSX"));
			notice.setTZSM(rs.getString("TZSM"));
			notice.setTZJE(rs.getString("TZJE"));
			notice.setTZRQ(rs.getDate("TZRQ"));
			notice.setTZCS(rs.getBigDecimal("TZCS"));
			notice.setTZID(rs.getBigDecimal("TZID"));
			
			notice.setCZJLXR(rs.getString("CZJLXR"));
			notice.setCZJLXDH(rs.getString("CZJLXDH"));
			
			return notice;
		}
	}

}
