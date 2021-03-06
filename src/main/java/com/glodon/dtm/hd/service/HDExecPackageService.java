/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:13:23
 */
package com.glodon.dtm.hd.service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.glodon.dtm.hd.model.HD_ExecPackage;

@Repository
public class HDExecPackageService {

	@Autowired
	@Qualifier("jdbcPrimaryTemplate")
	private JdbcTemplate jdbcPrinaryTemplate;

	public List<HD_ExecPackage> findByProjectId(String project_id) {
		StringBuffer buf = new StringBuffer();
		buf.append("select a.execute_notice_id, a.project_id from gb_t_project_exec_notice a where char_length(a.execute_notice_id)=10 and a.project_id=" + project_id);

		List<HD_ExecPackage> notices = jdbcPrinaryTemplate.query(buf.toString(), new HD_ExecProjectMapper());

		return notices;
	}

	public List<HD_ExecPackage> findAll() {
		StringBuffer buf = new StringBuffer();
		buf.append(" select a.execute_notice_id, a.project_id from gb_t_project_exec_notice a where char_length(a.execute_notice_id)=10");

		List<HD_ExecPackage> notices = jdbcPrinaryTemplate.query(buf.toString(), new HD_ExecProjectMapper());

		return notices;
	}

	private class HD_ExecProjectMapper implements RowMapper<HD_ExecPackage> {

		public HD_ExecPackage mapRow(ResultSet rs, int rowNum) throws SQLException {
			HD_ExecPackage o = new HD_ExecPackage();
			String xmid = rs.getString("execute_notice_id");
			o.setXmid((xmid == null || "".equals(xmid.trim())) ? null : new BigDecimal(xmid));
			o.setExecute_notice_id(xmid);
			o.setProject_id(rs.getString("project_id"));
			return o;
		}
	}

}
