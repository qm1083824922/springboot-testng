package com.sailheader.testng.factory.factorymethod.pizzastore.pizza;

/**
 * @author Porsche
 * @Date 2024/10/23 23:12
 */
public class BjPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("BJ Pepper Pizza");
        System.out.println("BJ Pepper pizza preparing...");
    }

    @Override
    public void bake() {
        System.out.println("BJ Pepper pizza baking...");
    }

    @Override
    public void cut() {
        System.out.println("BJ Pepper pizza cutting...");
    }

    @Override
    public void box() {
        System.out.println("BJ Pepper pizza boxing...");
    }
}
