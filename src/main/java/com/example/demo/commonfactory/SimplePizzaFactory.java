package com.example.demo.commonfactory;

/**
 * @Author Bob Simon
 * @Description:简单披萨工厂类
 * @Date :Created in 2018-04-20 18:00
 * @Modified By
 **/
public class SimplePizzaFactory {

    /**
     * 生成披萨
     * @param type
     * @return
     */
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }
        else if(type.equals("clam")){
            pizza = new ClamPizza();
        }
        else if(type.equals("pepperoni")){
            pizza = new PepperoniPizza();
        }
        else if(type.equals("veggie")){
            pizza = new VeggiePizze();
        }

        return pizza;
    }


}
