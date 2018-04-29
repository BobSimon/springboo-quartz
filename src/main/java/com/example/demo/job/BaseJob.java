package com.example.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-25 15:15
 * @Modified By
 **/
public interface BaseJob extends Job {

    public void execute(JobExecutionContext context) throws JobExecutionException;

}
