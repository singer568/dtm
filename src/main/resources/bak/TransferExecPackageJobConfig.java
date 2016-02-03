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
public class TransferExecPackageJobConfig {

	@Autowired
	private ExtraScheduleConfig extraConfig;

	@Bean
	public JobDetail buildExecJob() {
		return JobBuilder.newJob(TransferExecPackageJob.class)
				.withIdentity(extraConfig.getExecPackageJobName(), extraConfig.getExecPackageGroupName()).build();
	}

	@Bean
	public CronTrigger execPackageJobTriggerBean(@Qualifier("execPackageJobTriggerFactoryBean") CronTriggerFactoryBean jobTriggerFactoryBean) {
		return jobTriggerFactoryBean.getObject();
	}

	@Bean(name = "execPackageJobTriggerFactoryBean")
	public CronTriggerFactoryBean moduleJobTriggerFactoryBean() {
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setStartDelay(3000);
		stFactory.setJobDetail(buildExecJob());
		stFactory.isSingleton();
		stFactory.setCronExpression(extraConfig.getExecPackageCron());
		stFactory.setName(extraConfig.getExecPackageJobName());
		stFactory.setGroup(extraConfig.getExecPackageGroupName());
		//		stFactory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		//		stFactory.setRepeatInterval(TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
		return stFactory;
	}
}
