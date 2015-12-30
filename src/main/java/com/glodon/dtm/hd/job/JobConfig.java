package com.glodon.dtm.hd.job;

import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

/**
 * Created by andrew on 11/27/15.
 */
@Configuration
public class JobConfig {

	@Autowired
	private HDConfig hdConfig;

	@Bean
	public JobDetail buildJob() {
		return JobBuilder.newJob(TransferJob.class).withIdentity(hdConfig.getJob(), hdConfig.getGroup()).build();
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
		stFactory.setCronExpression(hdConfig.getCron());
		stFactory.setName(hdConfig.getJob());
		stFactory.setGroup(hdConfig.getGroup());
		//		stFactory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		//		stFactory.setRepeatInterval(TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
		return stFactory;
	}
}
