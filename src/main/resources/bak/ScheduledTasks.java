package com.glodon.dtm.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.glodon.dtm.common.service.ITransferDataService;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

	@Autowired
	private ITransferDataService tranService;

	//每1分钟执行一次
	@Scheduled(cron = "${schedule.repeat}")
	public void reportCurrentByCron() {
		tranService.transferData();
	}

}
