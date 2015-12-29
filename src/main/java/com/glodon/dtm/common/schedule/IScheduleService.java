/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月27日 下午6:38:28
 */
package com.glodon.dtm.common.schedule;

import java.util.List;

import com.glodon.dtm.common.model.Task;

public interface IScheduleService {

	void delete(String pk);

	void pause(String pk);

	void resume(String pk);

	void trigger(String pk);

	void unschedule(String pk);

	void rescheduleJob(String pk);

	List<Task> queryRunnningJobs();
}
