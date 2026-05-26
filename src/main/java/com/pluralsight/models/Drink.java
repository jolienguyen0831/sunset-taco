package com.pluralsight.models;

public class Drink extends MenuItem {
    protected String size;

    public Drink(String name, String size) {
        super("Drink");
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        if (size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("S")) {
            return 2.00;
        }
        if (size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("M")) {
            return 2.50;
        }
        return 3.00;
    }

}
