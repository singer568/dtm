/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:42:34
 */
package com.glodon.dtm.common.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.glodon.dtm.common.model.Log;
import com.glodon.dtm.common.repository.ILogRepository;

@Repository
public class LogRepositoryImpl implements ILogRepository {

	@Autowired
	@Qualifier("jdbcThirdTemplate")
	private JdbcTemplate jdbcThirdTemplate;

	public List<Log> findAll() {
		List<Log> logs = jdbcThirdTemplate.query("SELECT * FROM dtm_logs", new TransferLogMapper());

		return logs;
	}

	public int save(Log log) {
		StringBuffer sql = new StringBuffer()
				.append("insert into dtm_logs (pk,startDate,longStartDate, endDate, longEndDate, costs,createDate,allIds,noIds, successIds,failIds,failInfo,allCount,successCount,failCount,noCount) ")
				.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		Object[] params = new Object[] { log.getPk(), log.getStartDate(), log.getLongStartDate(), log.getEndDate(), log.getLongEndDate(),
				log.getCosts(), log.getCreateDate(), log.getAllIds(), log.getNoIds(), log.getSuccessIds(), log.getFailIds(), log.getFailInfo(),
				log.getAllCount(), log.getSuccessCount(), log.getFailCount(), log.getNoCount() };

		int count = jdbcThirdTemplate.update(sql.toString(), params);

		return count;
	}

	private class TransferLogMapper implements RowMapper<Log> {

		public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
			Log log = new Log();
			log.setCosts(rs.getString(Log.COSTS));
			log.setLongEndDate(rs.getString(Log.LONGENDDATE));
			log.setLongStartDate(rs.getString(Log.LONGSTARTDATE));
			log.setNoIds(rs.getString(Log.NOIDS));
			log.setCreateDate(rs.getDate(Log.CREATEDATE));
			log.setEndDate(rs.getDate(Log.ENDDATE));
			log.setFailIds(rs.getString(Log.FAILIDS));
			log.setFailInfo(rs.getString(Log.FAILINFO));
			log.setPk(rs.getString(Log.PK));
			log.setStartDate(rs.getDate(Log.STARTDATE));
			log.setSuccessIds(rs.getString(Log.SUCCESSIDS));
			log.setAllIds(Log.ALLIDS);
			log.setAllCount(rs.getString(Log.ALLCOUNT));
			log.setSuccessCount(rs.getString(Log.SUCCESSCOUNT));
			log.setFailCount(rs.getString(Log.FAILCOUNT));
			log.setNoCount(rs.getString(Log.NOCOUNT));
			return log;
		}

	}

}
