package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description：配料
 * @Date :Created in 2018-04-21 9:43
 * @Modified By
 **/
public class Milk extends  CondimentDecorator {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",牛奶";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.1;
    }

}
