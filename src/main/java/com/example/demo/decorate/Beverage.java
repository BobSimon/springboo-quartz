package com.example.demo.decorate;

/**
 * @Author Bob Simon
 * @Description:饮料，不同的饮料配料收费是不一样的
 * @Date :Created in 2018-04-21 9:32
 * @Modified By
 **/
public abstract class Beverage {

    public String description = "";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
