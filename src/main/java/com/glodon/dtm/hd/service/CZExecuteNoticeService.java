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

@Repository
public class CZExecuteNoticeService {

	@Autowired
	@Qualifier("jdbcSecondaryTemplate")
	private JdbcTemplate jdbcSecondaryTemplate;

	public CZ_ExecuteNotice findOne(String pk) {
		CZ_ExecuteNotice notice = jdbcSecondaryTemplate.queryForObject("SELECT * FROM v_hdggzy_cglx WHERE XMID=?", new BigDecimal[] { new BigDecimal(
				pk) }, new CZExecuteNoticeMapper());

		return notice;
	}

	public List<CZ_ExecuteNotice> findCurrentDay() {
		List<CZ_ExecuteNotice> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx where SJ>=? and SJ<=?",
				new Date[] { DateUtil.getBeginDate(), DateUtil.getEndDate() }, new CZExecuteNoticeMapper());

		return notices;
	}

	public List<CZ_ExecuteNotice> findAll() {
		List<CZ_ExecuteNotice> notices = jdbcSecondaryTemplate.query("SELECT * FROM v_hdggzy_cglx", new CZExecuteNoticeMapper());

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
			return notice;
		}

	}

}
