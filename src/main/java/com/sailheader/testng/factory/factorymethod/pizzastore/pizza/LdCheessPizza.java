package com.sailheader.testng.factory.factorymethod.pizzastore.pizza;

/**
 * @author Porsche
 * @Date 2024/10/23 23:13
 */
public class LdCheessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("Ld Cheese Pizza");
        System.out.println("Ld Cheese pizza preparing...");
    }
}
