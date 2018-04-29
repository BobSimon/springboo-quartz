package com.example.demo.controller;

import java.util.List;

import com.example.demo.aop.Log;
import com.example.demo.entity.JobAndTrigger;
import com.example.demo.entity.Result;
import com.example.demo.service.IJobAndTriggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Bob Simon
 * @Description：任务控制层
 * @Date :Created in 2018-04-25 15:10
 * @Modified By
 **/
@Api(tags ="Quartz任务")
@RestController
@RequestMapping(value="/job")
public class JobController{

    private static Logger log = LoggerFactory.getLogger(JobController.class);

    /**加入Qulifier注解，通过名称注入bean*/
    @Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Autowired
    private IJobAndTriggerService iJobAndTriggerService;

    /**
     * 新建任务
     * @param quartz
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiOperation(value="新建任务")
    @PostMapping("/add")
    @Log(desc = "新增定时任务",type = Log.LOG_TYPE.ADD)
    public Result save(JobAndTrigger quartz){
        log.info("新增任务");
        try {
            /**
             * 获取Scheduler实例、废弃、使用自动注入的scheduler、否则spring的service将无法注入
             * Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
             * 如果是修改 ,展示旧的任务
             */
            if(quartz.getOldJobGroup()!=null){
                JobKey key = new JobKey(quartz.getOldJobName(),quartz.getOldJobGroup());
                scheduler.deleteJob(key);
            }

            Class cls = Class.forName(quartz.getJobClassName()) ;
            cls.newInstance();

            /***构建job信息*/
            JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
                    quartz.getJobGroup())
                    .withDescription(quartz.getDescription()).build();

            /***触发时间点*/
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(),quartz.getJobGroup())
                    .startNow().withSchedule(cronScheduleBuilder).build();

            /***交由Scheduler安排触发*/
            scheduler.scheduleJob(job,trigger);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 获取任务列表
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value="任务列表")
    @PostMapping("/list")
    @Log(desc = "查询定时任务",type = Log.LOG_TYPE.SELECT)
    public Result list(@RequestParam(value = "jobName",required = false)String jobName,
                       @RequestParam("pageNo")Integer pageNo,
                       @RequestParam("pageSize")Integer pageSize){
        log.info("任务列表");

        List<JobAndTrigger> list = iJobAndTriggerService.listQuartzEntity(jobName,pageNo,pageSize);
        return Result.ok(list);
    }

    /**
     * 触发任务
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="触发任务")
    @PostMapping("/trigger")
    @Log(desc = "触发定时任务")
    public  Result trigger(JobAndTrigger quartz,HttpServletResponse response) {
        log.info("触发任务");
        try {
            JobKey key = new JobKey(quartz.getJobName(),quartz.getJobGroup());
            scheduler.triggerJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 停止任务
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="停止任务")
    @PostMapping("/pause")
    @Log(desc = "停止任务")
    public  Result pause(JobAndTrigger quartz,HttpServletResponse response) {
        log.info("停止任务");
        try {
            JobKey key = new JobKey(quartz.getJobName(),quartz.getJobGroup());
            scheduler.pauseJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 恢复任务
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="恢复任务")
    @PostMapping("/resume")
    @Log(desc = "恢复任务")
    public  Result resume(JobAndTrigger quartz,HttpServletResponse response) {
        log.info("恢复任务");
        try {
            JobKey key = new JobKey(quartz.getJobName(),quartz.getJobGroup());
            scheduler.resumeJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 移除任务
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="移除任务")
    @PostMapping("/remove")
    @Log(desc = "移除任务")
    public Result remove(JobAndTrigger quartz,HttpServletResponse response) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(quartz.getJobName(), quartz.getJobGroup());

            /***停止触发器*/
            scheduler.pauseTrigger(triggerKey);

            /**移除触发器*/
            scheduler.unscheduleJob(triggerKey);

            /***删除任务*/
            scheduler.deleteJob(JobKey.jobKey(quartz.getJobName(), quartz.getJobGroup()));
            System.out.println("removeJob:" + JobKey.jobKey(quartz.getJobName()));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

}
