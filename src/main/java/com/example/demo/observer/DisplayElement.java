package com.example.demo.observer;

/**
 * @Author Bob Simon
 * @Description:布告板显示接口
 * @Date :Created in 2018-04-21 8:55
 * @Modified By
 **/
public interface DisplayElement {

    /**
     * 当布告板需要显示的，就会调用此方法
     */
    public void display();

}
