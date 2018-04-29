package com.example.demo.commonfactory;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-20 18:05
 * @Modified By
 **/
public class CheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("CheesePizza披萨正在准备");
    }

    @Override
    public void bak() {
        System.out.println("CheesePizza披萨正在烘烤");
    }

    @Override
    public void cut() {
        System.out.println("CheesePizza披萨正在切片");
    }

    @Override
    public void box() {
        System.out.println("CheesePizza披萨正在装盒");
    }
}
