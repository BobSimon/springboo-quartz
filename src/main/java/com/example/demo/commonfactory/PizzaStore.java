package com.example.demo.commonfactory;

/**
 * @Author Bob Simon
 * @Description:披萨店
 * @Date :Created in 2018-04-20 18:21
 * @Modified By
 **/
public class PizzaStore {

    /**
     * 披萨店肯定是有个披萨生产的工厂
     */
    private SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory ){
        this.simplePizzaFactory = simplePizzaFactory;
    }

    /**
     * 你要定制的披萨类型
     * @param type
     * @return
     */
    public Pizza orderPizza(String type){

        Pizza pizza ;

        pizza = simplePizzaFactory.createPizza(type);

        /**
         * 准备
         */
        pizza.prepare();

        /**
         * 烘烤
         */
        pizza.bak();

        /**
         * 切片
         */
        pizza.cut();

        /**
         * 装盒
         */
        pizza.box();

        return pizza;
    }


}
