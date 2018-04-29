package com.example.demo.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-25 15:16
 * @Modified By
 **/
public class HelloJob implements BaseJob {

    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);

    public HelloJob() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /**_log.error("Hello Job执行时间: " + new Date());*/
        System.out.println("this is Hello Job");
    }

}
