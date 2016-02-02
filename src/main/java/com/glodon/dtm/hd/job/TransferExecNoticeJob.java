package com.glodon.dtm.hd.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.glodon.dtm.common.plugin.ITransferService;
import com.glodon.dtm.common.util.DateUtil;

/**
 * Created by andrew on 11/27/15.
 */
public class TransferExecNoticeJob implements Job {

	@Autowired
	@Qualifier("transferExecNotice")
	private ITransferService transferService;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(".......执行通知书....开始抓取.........." + DateUtil.getCurrentDateStr());
		transferService.transfer();
	}
}
