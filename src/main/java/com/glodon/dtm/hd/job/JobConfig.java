package com.glodon.dtm.hd.job;

import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

/**
 * Created by andrew on 11/27/15.
 */
@Configuration
public class JobConfig {

	public static final String JOB_NAME = "JOB_NAME_HDCZTRANSFER";

	public static final String GROUP_NAME = "GROUP_NAME_HDCZTRANSFER";

	@Bean
	public JobDetail buildJob() {
		return JobBuilder.newJob(TransferJob.class).withIdentity(JOB_NAME, GROUP_NAME).build();
	}

	@Bean
	public CronTrigger moduleJobTriggerBean(@Qualifier("transferJobTriggerFactoryBean") CronTriggerFactoryBean jobTriggerFactoryBean) {
		return jobTriggerFactoryBean.getObject();
	}

	@Bean(name = "transferJobTriggerFactoryBean")
	public CronTriggerFactoryBean moduleJobTriggerFactoryBean() {
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setStartDelay(3000);
		stFactory.setJobDetail(buildJob());
		stFactory.isSingleton();
		stFactory.setCronExpression("*/5 * * * * ?");
		stFactory.setName(JOB_NAME);
		stFactory.setGroup(GROUP_NAME);
		//		stFactory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		//		stFactory.setRepeatInterval(TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
		return stFactory;
	}
}
