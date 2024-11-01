package com.sailheader.testng.factory.factorymethod.pizzastore.order;

import com.sailheader.testng.factory.factorymethod.pizzastore.pizza.BjCheesePizza;
import com.sailheader.testng.factory.factorymethod.pizzastore.pizza.BjPepperPizza;
import com.sailheader.testng.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Porsche
 * @Date 2024/10/23 23:15
 */
public class BjOrderPizza extends OrderPizza {
    /**
     * 重写父类的抽象方法
     * @param orderType 订购披萨的类型
     * @return Pizza 披萨对象
     */
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BjCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BjPepperPizza();
        }
        return pizza;
    }


}
