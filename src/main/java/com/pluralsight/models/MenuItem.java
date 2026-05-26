package com.pluralsight.models;

public abstract class MenuItem implements Priceable {
    protected String name;
    protected double price;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract double getPrice();
}
