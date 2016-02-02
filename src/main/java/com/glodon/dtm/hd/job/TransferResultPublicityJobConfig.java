package com.glodon.dtm.hd.job;

import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

import com.glodon.dtm.hd.ExtraScheduleConfig;

/**
 * Created by andrew on 11/27/15.
 */
@Configuration
public class TransferResultPublicityJobConfig {

	@Autowired
	private ExtraScheduleConfig extraConfig;

	@Bean
	public JobDetail buildPublicityJob() {
		return JobBuilder.newJob(TransferResultPublicityJob.class)
				.withIdentity(extraConfig.getPublicityJobName(), extraConfig.getPublicityGroupName()).build();
	}

	@Bean
	public CronTrigger publicityJobTriggerBean(@Qualifier("publicityJobTriggerFactoryBean") CronTriggerFactoryBean jobTriggerFactoryBean) {
		return jobTriggerFactoryBean.getObject();
	}

	@Bean(name = "publicityJobTriggerFactoryBean")
	public CronTriggerFactoryBean moduleJobTriggerFactoryBean() {
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setStartDelay(3000);
		stFactory.setJobDetail(buildPublicityJob());
		stFactory.isSingleton();
		stFactory.setCronExpression(extraConfig.getPublicityCron());
		stFactory.setName(extraConfig.getPublicityJobName());
		stFactory.setGroup(extraConfig.getPublicityGroupName());
		//		stFactory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		//		stFactory.setRepeatInterval(TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
		return stFactory;
	}
}
