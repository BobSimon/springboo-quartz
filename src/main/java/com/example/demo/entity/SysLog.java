package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author Bob Simon
 * @Description：系统用户操作日志
 * @Date :Created in 2018-04-21 16:04
 * @Modified By
 **/
@Getter
@Setter
@ToString
public class SysLog {


    /**
     * id编号
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 操作类型,update还是select还是del等
     */
    private String type;

    /**
     * 描述内容，更新用户还是删除用户等
     */
    private String text;

    /**
     * 参数列表
     */
    private String param;

    /**
     * 创建时间
     */
    private Date createTime;
}
