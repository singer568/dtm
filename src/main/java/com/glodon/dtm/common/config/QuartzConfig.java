package com.glodon.dtm.common.config;

import java.util.List;

import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by andrew on 11/27/15.
 */
@Configuration
public class QuartzConfig {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired(required = false)
	private List<Trigger> triggers;

	/**
	 * Create the quartz scheduler.
	 * Will scan for all Trigger's in the project and schedule them if a trigger doesn't exist in the database.
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setJobFactory(jobFactory());
		if (triggers != null && !triggers.isEmpty()) {
			scheduler.setTriggers(triggers.toArray(new Trigger[triggers.size()]));
		}

		return scheduler;
	}

	@Bean(name = "quartzScheduler")
	public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) {
		return schedulerFactoryBean.getObject();
	}

	public JobFactory jobFactory() {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

}
