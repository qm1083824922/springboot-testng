package com.sailheader.testng.factory.factorymethod.pizzastore.order;

import com.sailheader.testng.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Porsche
 * @Date 2024/10/23 23:14
 */
public abstract class OrderPizza {

    public abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do{
            orderType = getType();
            //抽象方法，由工厂子类完成
            pizza = createPizza(orderType);
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    private String getType(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = bufferedReader.readLine();
            return str;
        }catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
