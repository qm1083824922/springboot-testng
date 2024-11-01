package com.sailheader.testng.factory.factorymethod.pizzastore.order;

import com.sailheader.testng.factory.factorymethod.pizzastore.pizza.LdCheessPizza;
import com.sailheader.testng.factory.factorymethod.pizzastore.pizza.LdPepperPizza;
import com.sailheader.testng.factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * @author Porsche
 * @Date 2024/10/23 23:16
 */
public class LdOrderPizza extends OrderPizza {
    /**
     *  重写父类的createPizza方法，根据订单类型创建不同的披萨
     * @param orderType 订购披萨的类型
     * @return Pizza 披萨对象
     */
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LdCheessPizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LdPepperPizza();
        }
        return pizza;
    }
}