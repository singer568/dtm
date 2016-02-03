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

import com.glodon.dtm.hd.model.CZ_ExecPackage;

@Repository
public class CZExecPackageService {

	@Autowired
	@Qualifier("jdbcSecondaryTemplate")
	private JdbcTemplate jdbcSecondaryTemplate;

	
	public boolean isExists(BigDecimal xmid) {
		int count = jdbcSecondaryTemplate.queryForObject("SELECT count(1) FROM t_ggzy_zxtzs_xm WHERE XMID=?",
				new BigDecimal[] { xmid}, Integer.class);
		if (count > 0) {
			return true;
		}

		return false;
	}
	
	public int deleteAll() {
		int count = jdbcSecondaryTemplate.update("delete FROM t_ggzy_zxtzs_xm");

		return count;
	}

	public int deleteByProjectPk(String project_id) {
		int count = jdbcSecondaryTemplate.update("delete FROM t_ggzy_zxtzs_xm WHERE project_id=" + project_id);

		return count;
	}

	public int save(CZ_ExecPackage o) {
		StringBuffer sql = new StringBuffer().append("insert into t_ggzy_zxtzs_xm (xmid,execute_notice_id,project_id, package_id) ").append(
				" values(?,?,?,?)");

		Object[] params = new Object[] { o.getXmid(), o.getExecute_notice_id(), o.getProject_id(), o.getPackage_id() };

		int count = jdbcSecondaryTemplate.update(sql.toString(), params);

		return count;
	}

	private class CZ_ExecProjectMapper implements RowMapper<CZ_ExecPackage> {

		public CZ_ExecPackage mapRow(ResultSet rs, int rowNum) throws SQLException {
			CZ_ExecPackage o = new CZ_ExecPackage();
			o.setXmid(rs.getBigDecimal("xmid"));
			o.setExecute_notice_id(rs.getString("execute_notice_id"));
			o.setProject_id(rs.getString("project_id"));
			o.setPackage_id(rs.getString("package_id"));
			return o;
		}
	}
}
