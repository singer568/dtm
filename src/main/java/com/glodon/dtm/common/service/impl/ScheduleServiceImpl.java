/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月27日 下午6:38:28
 */
package com.glodon.dtm.common.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.glodon.dtm.common.model.Task;
import com.glodon.dtm.common.repository.ITaskRepository;
import com.glodon.dtm.common.service.IScheduleService;

@Service
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	@Qualifier("quartzScheduler")
	private Scheduler scheduler;

	@Autowired
	private ITaskRepository taskRepository;

	public void delete(String pk) {
		try {
			Task task = taskRepository.queryByPk(pk);
			JobKey key = new JobKey(task.getTaskName(), task.getTaskGroup());
			boolean isExist = scheduler.checkExists(key);
			if (isExist) {
				scheduler.deleteJob(key);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void pause(String pk) {
		try {
			Task task = taskRepository.queryByPk(pk);
			JobKey key = new JobKey(task.getTaskName(), task.getTaskGroup());
			boolean isExist = scheduler.checkExists(key);
			if (isExist) {
				scheduler.pauseJob(key);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

	public void resume(String pk) {
		try {
			Task task = taskRepository.queryByPk(pk);
			JobKey key = new JobKey(task.getTaskName(), task.getTaskGroup());
			boolean isExist = scheduler.checkExists(key);
			if (isExist) {
				scheduler.resumeJob(key);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void trigger(String pk) {
		try {
			Task task = taskRepository.queryByPk(pk);
			JobKey key = new JobKey(task.getTaskName(), task.getTaskGroup());
			boolean isExist = scheduler.checkExists(key);
			if (isExist) {
				scheduler.triggerJob(key);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void unschedule(String pk) {
		try {
			Task task = taskRepository.queryByPk(pk);
			TriggerKey key = new TriggerKey(task.getTaskName(), task.getTaskGroup());
			boolean isExist = scheduler.checkExists(key);
			if (isExist) {
				scheduler.unscheduleJob(key);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void rescheduleJob(String pk) {
		try {
			Task task = taskRepository.queryByPk(pk);
			TriggerKey key = new TriggerKey(task.getTaskName(), task.getTaskGroup());
			boolean isExist = scheduler.checkExists(key);
			if (isExist) {
				CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(task.getTaskName(), task.getTaskGroup()).startNow()
						.withSchedule(CronScheduleBuilder.cronSchedule(task.getTaskCron())).build();
				scheduler.rescheduleJob(key, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public List<Task> queryRunnningJobs() {
		try {
			Set<TriggerKey> set = scheduler.getTriggerKeys(GroupMatcher.anyTriggerGroup());

			Iterator<TriggerKey> it = set.iterator();

			List<Task> result = null;
			while (it.hasNext()) {
				if (result == null) {
					result = new ArrayList<Task>();
				}
				TriggerKey key = it.next();
				CronTrigger trigger = (CronTrigger) scheduler.getTrigger(key);
				Task task = new Task();
				task.setTaskCode(trigger.getJobKey().getName());
				task.setTaskName(trigger.getJobKey().getName());
				task.setTaskGroup(trigger.getJobKey().getGroup());
				task.setTaskCron(trigger.getCronExpression());

				Task tmp = taskRepository.queryByNameGroup(task.getTaskName(), task.getTaskGroup());
				if (null == tmp || tmp.getTaskPk() == null) {
					task.setTaskPk(UUID.randomUUID().toString());
					taskRepository.save(task);
				} else {
					task.setTaskPk(tmp.getTaskPk());
				}
				result.add(task);
			}
			return result;
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 
	 
	 */

}
