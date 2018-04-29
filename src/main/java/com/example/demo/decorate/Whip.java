package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-21 9:48
 * @Modified By
 **/
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",奶泡";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.1;
    }



}
