package com.example.demo.config;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-25 15:23
 * @Modified By
 **/
@Configuration
public class SchedulerConfig {


    @Autowired
    private SpringJobFactory springJobFactory;

    @Bean(name="SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setAutoStartup(true);

        /***延时5秒启动*/
        factory.setStartupDelay(5);
        factory.setQuartzProperties(quartzProperties());
        factory.setJobFactory(springJobFactory);
        return factory;
    }

    /**
     * 读入配置文件
     * @return
     * @throws IOException
     */
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    /**
     * quartz初始化监听器
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /**
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name="Scheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

}
