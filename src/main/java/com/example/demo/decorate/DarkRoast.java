package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-21 9:41
 * @Modified By
 **/
public class DarkRoast extends Beverage{

    public DarkRoast() {
        description = "这是一杯低咖啡因咖啡";
    }

    @Override
    public double cost() {
        return 1.05;
    }



}
