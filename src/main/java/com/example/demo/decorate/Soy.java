package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description:豆浆
 * @Date :Created in 2018-04-21 9:46
 * @Modified By
 **/
public class Soy extends CondimentDecorator{

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",豆浆";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.15;
    }


}
