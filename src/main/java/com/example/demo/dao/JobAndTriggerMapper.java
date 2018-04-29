package com.example.demo.dao;

import com.example.demo.entity.JobAndTrigger;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-25 15:11
 * @Modified By
 **/
public interface JobAndTriggerMapper {


    public List<JobAndTrigger> getJobAndTriggerDetails();


    /**
     * 计算job的个数
     * @param quartz
     * @return
     */
    long listQuartzEntityNum(JobAndTrigger quartz);

    /**
     * 查询出任务
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<JobAndTrigger> listQuartzEntity(@Param("jobName")String jobName,@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
}
