package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-21 9:40
 * @Modified By
 **/
public class Decat extends Beverage{

    public Decat() {
        description = "这是一杯深焙咖啡";
    }

    /**
     * 售价
     * @return
     */
    @Override
    public double cost() {
        return 0.99;
    }

}
