package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description：综合咖啡
 * @Date :Created in 2018-04-21 9:36
 * @Modified By
 **/
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "这是一杯综合咖啡";
    }

    @Override
    public double cost() {
        return 0.89;
    }

}
