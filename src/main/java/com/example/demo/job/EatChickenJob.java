package com.example.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

/**
 * @Author: Bob Simon
 * @Description:吃鸡任务
 * @Date: Created in 9:31 2018\4\29
 */
public class EatChickenJob implements Job,Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * job执行的内容
	 * @param arg0
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("大吉大利、今晚吃鸡");
	}

}
