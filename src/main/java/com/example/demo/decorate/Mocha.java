package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description:配料
 * @Date :Created in 2018-04-21 9:45
 * @Modified By
 **/
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return  beverage.getDescription()+",摩卡";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.2;
    }

}
