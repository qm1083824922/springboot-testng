package com.sailheader.testng.factory.factorymethod.pizzastore.pizza;

/**
 * @author Porsche
 * @Date 2024/10/23 23:12
 */
public class BjCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("BJ Cheese Pizza");
        System.out.println("BJ Cheese pizza preparing...");
    }
}
