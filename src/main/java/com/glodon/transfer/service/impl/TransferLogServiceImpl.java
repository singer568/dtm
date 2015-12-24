/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:42:34
 */
package com.glodon.transfer.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.glodon.transfer.model.TransferLog;
import com.glodon.transfer.service.ITransferLogService;

@Repository
public class TransferLogServiceImpl implements ITransferLogService {

	@Autowired
	@Qualifier("jdbcPrimaryTemplate")
	private JdbcTemplate jdbcPrinaryTemplate;

	public List<TransferLog> findAll() {
		List<TransferLog> logs = jdbcPrinaryTemplate.query("SELECT * FROM dtm_logs", new TransferLogMapper());

		return logs;
	}

	public int save(TransferLog log) {
		StringBuffer sql = new StringBuffer().append("insert into dtm_logs (pk,startDate,endDate,costs,createDate,successIds,failIds,failInfo) ")
				.append(" values(?,?,?,?,?,?,?,?)");

		Object[] params = new Object[] { log.getPk(), log.getStartDate(), log.getEndDate(), log.getCosts(), log.getCreateDate(), log.getSuccessIds(),
				log.getFailIds(), log.getFailInfo() };

		int count = jdbcPrinaryTemplate.update(sql.toString(), params);

		return count;
	}

	private class TransferLogMapper implements RowMapper<TransferLog> {

		public TransferLog mapRow(ResultSet rs, int rowNum) throws SQLException {
			TransferLog log = new TransferLog();
			log.setCosts(rs.getLong(TransferLog.COSTS));
			log.setCreateDate(rs.getDate(TransferLog.CREATEDATE));
			log.setEndDate(rs.getDate(TransferLog.ENDDATE));
			log.setFailIds(rs.getString(TransferLog.FAILIDS));
			log.setFailInfo(rs.getString(TransferLog.FAILINFO));
			log.setPk(rs.getString(TransferLog.PK));
			log.setStartDate(rs.getDate(TransferLog.STARTDATE));
			log.setSuccessIds(rs.getString(TransferLog.SUCCESSIDS));
			return log;
		}

	}

}
