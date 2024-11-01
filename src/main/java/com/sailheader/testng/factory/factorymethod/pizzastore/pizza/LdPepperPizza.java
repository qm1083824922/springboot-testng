package com.sailheader.testng.factory.factorymethod.pizzastore.pizza;

/**
 * @author Porsche
 * @Date 2024/10/23 23:13
 */
public class LdPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("Ld Pepper Pizza");
        System.out.println("Ld Pepper pizza preparing...");
    }
}
