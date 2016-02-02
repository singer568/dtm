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
public class TransferResultPublicityJob implements Job {

	@Autowired
	@Qualifier("transferResultPublicity")
	private ITransferService transferService;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(".......中标结果....开始回传.........." + DateUtil.getCurrentDateStr());
		transferService.transfer();
	}
}
