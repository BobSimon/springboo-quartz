package com.example.demo.commonfactory;

/**
 * @Author Bob Simon
 * @Description:抽象工厂
 * @Date :Created in 2018-04-20 18:03
 * @Modified By
 **/
public abstract class Pizza {

    /**
     * 准备
     */
    public abstract void prepare();

    /**
     * 烘烤
     */
    public abstract void bak();

    /**
     * 切片
     */
    public abstract void cut();

    /**
     * 装包
     */
    public abstract void box();

}
