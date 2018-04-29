package com.example.demo.job;

import com.example.demo.service.IJobAndTriggerService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Author: Bob Simon
 * @Description: 实现序列化接口、防止重启应用出现quartz Couldn't retrieve job because a required class was not found 的问题
 * @Date: Created in 9:32 2018\4\29
 */
public class TestJob implements Job,Serializable {

	private static final long serialVersionUID = 1L;
	   
    @Autowired  
    private IJobAndTriggerService jobService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		/**注入jobService 执行相关业务操作*/
		System.out.println(jobService);
		System.out.println("任务执行成功");
	}

}
