package com.sailheader.testng.factory.factorymethod.pizzastore.pizza;

/**
 * @author Porsche
 * @Date 2024/10/23 23:11
 */
public abstract class Pizza {

    protected String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println("bake");
    }

    public void cut() {
        System.out.println("cut");
    }

    public void box() {
        System.out.println("box");
    }
}
