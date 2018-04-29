package com.example.demo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Bob Simon
 * @Description：log配置
 * @Date :Created in 2018-04-21 16:07
 * @Modified By
 **/
@Configuration
public class LogConfig {

    @Bean(name = "logAspect")
    public LogAspect getLogAspect(){
        return new LogAspect();
    }

}
