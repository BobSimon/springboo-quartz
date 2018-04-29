package com.example.demo.service;

import com.example.demo.entity.JobAndTrigger;

import java.util.List;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-25 15:19
 * @Modified By
 **/
public interface IJobAndTriggerService {

    //public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);

    /**
     * 查询定时任务实体类
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<JobAndTrigger> listQuartzEntity(String jobName,Integer pageNo,Integer pageSize);

    /**
     * 查总的任务数量
     * @param quartz
     * @return
     */
    Long listQuartzEntityNum(JobAndTrigger quartz);

}
