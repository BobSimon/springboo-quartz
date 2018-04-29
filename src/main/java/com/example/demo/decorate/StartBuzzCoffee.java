package com.example.demo.decorate;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Bob Simon
 * @Description:开始煮咖啡
 * @Date :Created in 2018-04-21 9:50
 * @Modified By
 **/
public class StartBuzzCoffee {



    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+",$"+beverage.cost());
        System.out.println("========================");

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()+",$" + beverage2.cost());
    }


}
