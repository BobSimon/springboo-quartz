package com.example.demo.aop;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited

/**
 * @Author Bob Simon
 * @Description:记录日志
 * @Date :Created in 2018-04-21 16:06
 * @Modified By
 **/
public @interface Log {

    public enum LOG_TYPE{ADD,UPDATE,DEL,SELECT,ATHOR};

    /**内容*/
    String desc();

    /**类型 curd*/
    LOG_TYPE type() default LOG_TYPE.ATHOR;
}
