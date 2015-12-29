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

import com.glodon.dtm.common.model.Task;
import com.glodon.dtm.common.repository.ITaskRepository;

@Repository
public class TaskRepositoryImpl implements ITaskRepository {

	@Autowired
	@Qualifier("jdbcThirdTemplate")
	private JdbcTemplate jdbcThirdTemplate;

	public List<Task> findAll() {
		List<Task> tasks = jdbcThirdTemplate.query("SELECT * FROM dtm_task", new JObMapper());

		return tasks;
	}

	public int save(Task task) {
		StringBuffer sql = new StringBuffer().append("insert into dtm_task (taskpk,taskcode,taskname,taskgroup, tasktype, taskcron) ").append(" values(?,?,?,?,?,?)");

		Object[] params = new Object[] { task.getTaskPk(), task.getTaskCode(), task.getTaskName(), task.getTaskGroup(), task.getTaskType(), task.getTaskCron() };

		int count = jdbcThirdTemplate.update(sql.toString(), params);

		return count;
	}
	public Task queryByNameGroup(String name, String group){
		
		try{
			Task task = jdbcThirdTemplate.queryForObject("SELECT * FROM dtm_task where taskName = ? and taskGroup=?", new String[] { name,  group}, new JObMapper());
			return task;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public Task queryByPk(String pk) {
		Task task = jdbcThirdTemplate.queryForObject("SELECT * FROM dtm_task where taskPk = ?", new String[] { pk }, new JObMapper());

		return task;
	}

	private class JObMapper implements RowMapper<Task> {

		public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
			Task job = new Task();
			job.setTaskCode(rs.getString(Task.TASKCODE));
			job.setTaskName(rs.getString(Task.TASKNAME));
			job.setTaskCron(rs.getString(Task.TASKCRON));
			job.setTaskType(rs.getString(Task.TASKTYPE));
			job.setTaskGroup(rs.getString(Task.TASKGROUP));
			job.setTaskPk(rs.getString(Task.TASKPK));
			return job;
		}
	}

	public int update(Task task) {
		StringBuffer sql = new StringBuffer().append("update dtm_task set taskcode=?,taskname=?,taskgroup=?, tasktype=?, taskcron=? where taskpk=? ");

		Object[] params = new Object[] {  task.getTaskCode(), task.getTaskName(), task.getTaskGroup(), task.getTaskType(), task.getTaskCron(), task.getTaskPk() };

		int count = jdbcThirdTemplate.update(sql.toString(), params);

		return count;
	}
}
