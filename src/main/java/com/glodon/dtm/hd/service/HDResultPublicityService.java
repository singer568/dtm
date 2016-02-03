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

import com.glodon.dtm.hd.model.HD_ResultPublicity;

@Repository
public class HDResultPublicityService {

	@Autowired
	@Qualifier("jdbcPrimaryTemplate")
	private JdbcTemplate jdbcPrinaryTemplate;

	public HD_ResultPublicity findOne(String bbid) {

		StringBuffer buf = new StringBuffer();
		buf.append("select d.execute_notice_id as xmid, b.package_id as bbid,  b.pub_time_start as lrsj, c.agency_name as lrr, a.pub_org_name as zbgysmc, a.calibration_date as zbrq, a.pub_price as zbdj,a.pub_price as zbje, ");
		buf.append(" c.AGENT_PHONE as fzrsj, c.BID_AGENT as cgxmfzr, c.PROJECT_CODE as zbbh, c.TENDER_WAY  as zbcgfsdm");
		buf.append(" from gb_t_result_publicity a left join gb_t_result_publicity_item b on a.result_publicity_id = b.result_publicity_id ");
		buf.append(" left outer join gb_t_project_info c on a.project_id = c.project_id left outer join gb_r_execute_package d on b.package_id = d.package_id ");
		buf.append(" where a.pub_status = 'PASSED'  and b.package_id=? ");

		List<HD_ResultPublicity> notices = jdbcPrinaryTemplate.query(buf.toString(), new String[] { bbid }, new HD_ResultPublicityMapper());
		if (notices == null || notices.size() < 1) {
			return null;
		}
		return notices.get(0);
	}

	public List<HD_ResultPublicity> findDatePair(Date startDate, Date endDate) {
		StringBuffer buf = new StringBuffer();
		buf.append("		select  d.execute_notice_id as xmid, b.package_id as bbid,  a.RESULT_PUBLICLY_DATE as lrsj, c.agency_name as lrr, ");
		buf.append("		b.pub_org_name as zbgysmc, a.calibration_date as zbrq, b.pub_price as zbdj,b.pub_price as zbje, ");
		buf.append("		c.AGENT_PHONE as fzrsj, e.PERSON_NAME as cgxmfzr, c.PROJECT_CODE as zbbh, c.TENDER_WAY  as zbcgfsdm ");
		buf.append("		from gb_t_result_publicity a left join gb_t_result_publicity_item b on a.result_publicity_id = b.result_publicity_id ");
		buf.append("		left outer join gb_t_project_info c on a.project_id = c.project_id left outer join gb_t_bid_package d on b.package_id = d.package_id  ");
		buf.append(" left outer join gf_t_person_info e on c.BID_AGENT = e.PERSON_ID ");
		buf.append(" where a.pub_status = 'PASSED' AND e.DATA_STATUS = 'VALID' and b.CREATE_TIME>=? and b.CREATE_TIME <= ?");

		List<HD_ResultPublicity> notices = jdbcPrinaryTemplate.query(buf.toString(), new Date[] { startDate, endDate },
				new HD_ResultPublicityMapper());

		return notices;
	}

	public List<HD_ResultPublicity> findAll() {
		StringBuffer buf = new StringBuffer();
		buf.append("		select  d.execute_notice_id as xmid, b.package_id as bbid,  a.RESULT_PUBLICLY_DATE as lrsj, c.agency_name as lrr, ");
		buf.append("		b.pub_org_name as zbgysmc, a.calibration_date as zbrq, b.pub_price as zbdj,b.pub_price as zbje, ");
		buf.append("		c.AGENT_PHONE as fzrsj, e.PERSON_NAME as cgxmfzr, c.PROJECT_CODE as zbbh, c.TENDER_WAY  as zbcgfsdm ");
		buf.append("		from gb_t_result_publicity a left join gb_t_result_publicity_item b on a.result_publicity_id = b.result_publicity_id ");
		buf.append("		left outer join gb_t_project_info c on a.project_id = c.project_id left outer join gb_t_bid_package d on b.package_id = d.package_id  ");
		buf.append(" left outer join gf_t_person_info e on c.BID_AGENT = e.PERSON_ID ");
		buf.append(" where a.pub_status = 'PASSED' AND e.DATA_STATUS = 'VALID'");

		List<HD_ResultPublicity> notices = jdbcPrinaryTemplate.query(buf.toString(), new HD_ResultPublicityMapper());

		return notices;
	}

	private class HD_ResultPublicityMapper implements RowMapper<HD_ResultPublicity> {

		public HD_ResultPublicity mapRow(ResultSet rs, int rowNum) throws SQLException {
			HD_ResultPublicity notice = new HD_ResultPublicity();
			notice.setXmid(rs.getString("xmid"));
			notice.setBbid(rs.getString("bbid"));
			notice.setShzt("0");
			notice.setLrsj(rs.getDate("lrsj"));
			notice.setLrr(rs.getString("lrr"));
			notice.setZbgysmc(rs.getString("zbgysmc"));
			notice.setZbrq(rs.getDate("zbrq"));
			notice.setZbdj(rs.getBigDecimal("zbdj"));
			notice.setZbje(rs.getBigDecimal("zbje"));
			notice.setFzrsj(rs.getString("fzrsj"));
			notice.setFzrdh(null);
			notice.setCgxmfzr(rs.getString("cgxmfzr"));
			notice.setZbbh(rs.getString("zbbh"));
			notice.setZbcgfsdm(rs.getString("zbcgfsdm"));
			notice.setSfbgcgfs(new BigDecimal("0"));
			return notice;
		}
	}

}
