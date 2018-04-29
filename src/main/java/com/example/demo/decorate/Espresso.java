package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description：浓缩咖啡
 * @Date :Created in 2018-04-21 9:37
 * @Modified By
 **/
public class Espresso extends Beverage{

    public Espresso() {
        description = "这是一杯浓缩咖啡";
    }

    /**
     * 售价
     * @return
     */
    @Override
    public double cost() {
        return 1.99;
    }


}
