package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JobAndTriggerMapper;
import com.example.demo.entity.JobAndTrigger;
import com.example.demo.service.IJobAndTriggerService;

import java.util.List;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-25 15:20
 * @Modified By
 **/

@Service
public class JobAndTriggerImpl implements IJobAndTriggerService{

    @Autowired
    JobAndTriggerMapper jobAndTriggerMapper;
    /**
     * 查询有多少个任务
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<JobAndTrigger> listQuartzEntity(String jobName, Integer pageNo, Integer pageSize) {
        return jobAndTriggerMapper.listQuartzEntity(jobName,pageNo,pageSize);
    }

    /**
     * 查询任务个数
     * @param quartz
     * @return
     */
    @Override
    public Long listQuartzEntityNum(JobAndTrigger quartz) {
        return jobAndTriggerMapper.listQuartzEntityNum(quartz);
    }

    /*@Autowired
    private JobAndTriggerMapper jobAndTriggerMapper;

    public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
        PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
        return page;
    }*/


}
