/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:13:23
 */
package com.glodon.dtm.hd.service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.glodon.dtm.hd.model.CZ_ResultPublicity;

@Repository
public class CZResultPublicityService {

	@Autowired
	@Qualifier("jdbcSecondaryTemplate")
	private JdbcTemplate jdbcSecondaryTemplate;

	public boolean isExists(String bbid) {
		int count = jdbcSecondaryTemplate.queryForObject("SELECT count(1) FROM t_hdggzy_zbjg WHERE bbid=?", new String[] { bbid }, Integer.class);
		if (count > 0) {
			return true;
		}

		return false;
	}

	public int deleteDetailByPk(String bbid) {
		int count = jdbcSecondaryTemplate.update("delete FROM t_hdggzy_zbjg WHERE bbid=" + bbid);

		return count;
	}

	public int save(CZ_ResultPublicity o) {
		StringBuffer sql = new StringBuffer().append(
				"insert into t_hdggzy_zbjg (SFBGCGFS,ZBCGFSDM,ZBCGFSMC,ZBBH,CGXMFZR,FZRDH,FZRSJ,ZBJE,ZBDJ,ZBRQ,ZBGYSMC,LRR,LRSJ,SHZT,XMID,BBID) ")
				.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		Object[] params = new Object[] { o.getSfbgcgfs(), o.getZbcgfsdm(), o.getZbcgfsmc(), o.getZbbh(), o.getCgxmfzr(), o.getFzrdh(), o.getFzrsj(),
				o.getZbje(), o.getZbdj(), o.getZbrq(), o.getZbgysmc(), o.getLrr(), o.getLrsj(), o.getShzt(), o.getXmid(), o.getBbid() };

		int count = jdbcSecondaryTemplate.update(sql.toString(), params);

		return count;
	}

	private class CZ_ResultPublicityMapper implements RowMapper<CZ_ResultPublicity> {

		public CZ_ResultPublicity mapRow(ResultSet rs, int rowNum) throws SQLException {
			CZ_ResultPublicity notice = new CZ_ResultPublicity();
			notice.setXmid(rs.getString("xmid"));
			notice.setBbid(rs.getString("bbid"));
			notice.setShzt(new BigDecimal("1"));
			notice.setLrsj(rs.getDate("lrsj"));
			notice.setLrr(rs.getString("lrr"));
			notice.setZbgysmc(rs.getString("zbgysmc"));
			notice.setZbrq(rs.getDate("zbrq"));
			notice.setZbdj(rs.getBigDecimal("zbdj"));
			notice.setZbje(rs.getBigDecimal("zbje"));
			notice.setFzrsj(rs.getString("fzrsj"));
			notice.setFzrdh(rs.getString("fzrdh"));
			notice.setCgxmfzr(rs.getString("cgxmfzr"));
			notice.setZbbh(rs.getString("zbbh"));
			notice.setZbcgfsdm(rs.getBigDecimal("zbcgfsdm"));
			notice.setZbcgfsmc(rs.getString("zbcgfsmc"));
			notice.setSfbgcgfs(new BigDecimal("0"));
			return notice;
		}
	}
}
