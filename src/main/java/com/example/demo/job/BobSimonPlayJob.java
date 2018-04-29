package com.example.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author Bob Simon
 * @Description:Bob Simon创建的任务
 * @Date :Created in 2018-04-29 11:19
 * @Modified By
 **/
public class BobSimonPlayJob implements Job{

    /**
     * job执行的内容
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /**
         *  怎么执行这里面的任务呢哈
         */
        System.out.println("Bob Simon is an awesome man in the world!");
    }

}
