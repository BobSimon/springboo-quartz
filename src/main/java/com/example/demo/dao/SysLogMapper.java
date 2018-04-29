package com.example.demo.dao;

import com.example.demo.entity.SysLog;

import java.util.List;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-21 16:12
 * @Modified By
 **/
public interface SysLogMapper {

    /**
     * 删除系统日志
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入日志记录
     * @param record
     * @return
     */
    int insert(SysLog record);

    /**
     * 通过主键来查询日志
     * @param id
     * @return
     */
    SysLog selectByPrimaryKey(Integer id);

    /**
     * 通过主键更新日志
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysLog record);

    /**
     * 分页查询系统日志
     * @param sysLog
     * @return
     */
    List<SysLog> selectListByPage(SysLog sysLog);
}
