package com.example.demo.config;

import com.example.demo.entity.JobAndTrigger;
import com.example.demo.service.IJobAndTriggerService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: Bob Simon
 * @Description: 初始化一个测试Demo任务
 * @Date: Created in 9:35 2018\4\29 0029
 */
@Component
public class TaskRunner implements ApplicationRunner{
    
	private final static Logger LOGGER = LoggerFactory.getLogger(TaskRunner.class);
	
	@Autowired
    private IJobAndTriggerService jobService;

	@Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;
	
    @SuppressWarnings({ "rawtypes","unchecked" })
	@Override
    public void run(ApplicationArguments var) throws Exception{
    	Long count = jobService.listQuartzEntityNum(null);
    	if(count==0){
    		LOGGER.info("初始化测试任务");
    		JobAndTrigger quartz = new JobAndTrigger();
    		quartz.setJobName("test01");
    		quartz.setJobGroup("test");
    		quartz.setDescription("测试任务");
    		quartz.setJobClassName("com.example.demo.job.EatChickenJob");
    		quartz.setCronExpression("0/20 * * * * ?");
   	        Class cls = Class.forName(quartz.getJobClassName()) ;
   	        cls.newInstance();

   	        /**构建job信息*/
   	        JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
   	        		quartz.getJobGroup())
   	        		.withDescription(quartz.getDescription()).build();

   	        /**触发时间点*/
   	        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
   	        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(),quartz.getJobGroup())
   	                .startNow().withSchedule(cronScheduleBuilder).build();	

   	        /**交由Scheduler安排触发*/
   	        scheduler.scheduleJob(job, trigger);
    	}

    }

}