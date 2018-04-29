package com.example.demo.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-25 15:17
 * @Modified By
 **/
public class NewJob implements BaseJob {


    private static Logger _log = LoggerFactory.getLogger(NewJob.class);

    public NewJob() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
       /** _log.error("New Job执行时间: " + new Date());*/
        System.out.println("this is new Job");
    }


}
