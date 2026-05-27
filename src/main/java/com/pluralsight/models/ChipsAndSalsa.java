package com.pluralsight.models;

public class ChipsAndSalsa extends MenuItem {
    public ChipsAndSalsa(String name) {
        super(name);
        this.price = getPrice();
    }

    @Override
    public double getPrice() {
        return  1.50;
    }

    @Override
    public String toString() {
        return String.format("""
                    CHIPS & SALSA
            ----------------------------------------
            Chips  : %s
            Price : $%.2f
            """, name, price);
    }
}
