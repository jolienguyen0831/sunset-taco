package com.pluralsight.models;

public class Drink extends MenuItem {
    protected String size;
    protected String flavor;

    public Drink(String size, String flavor) {
        super("Drink");
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        if (size.equalsIgnoreCase("Small")) {
            return 2.00;
        }
        if (size.equalsIgnoreCase("Medium")) {
            return 2.50;
        }
        //Large
        return 3.00;
    }

    @Override
    public String toString() {
        return String.format("""
            Drink
            Size   : %s
            Flavor : %s
            Price  : $%.2f
            """, size, flavor, getPrice());
    }

}
