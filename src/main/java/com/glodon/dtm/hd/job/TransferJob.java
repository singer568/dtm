package com.glodon.dtm.hd.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glodon.dtm.common.plugin.ITransferService;

/**
 * Created by andrew on 11/27/15.
 */
public class TransferJob implements Job {

	@Autowired
	private ITransferService transferService;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("...........抓取执行中.........." + System.currentTimeMillis());
		transferService.transfer();
	}
}
