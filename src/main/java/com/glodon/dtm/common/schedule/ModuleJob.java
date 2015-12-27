package com.glodon.dtm.common.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by andrew on 11/27/15.
 */
public class ModuleJob  extends QuartzJobBean {

    @Autowired
    private ModuleJobService moduleJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(moduleJobService.getValue());
    }
}
