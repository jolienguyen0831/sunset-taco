package com.pluralsight.models;

import java.util.ArrayList;

public class Taco implements MenuItem {
    protected String size;
    protected String shell;
    protected ArrayList<String> regularToppings;
    protected ArrayList<String> sauces;
    protected ArrayList<String> sides;
    protected String meat;
    protected boolean extraMeat;
    protected String cheese;
    protected boolean extraCheese;
    protected boolean coveredInSalsaAndQueso;

    public Taco(String size, String shell) {
        this.size = size;
        this.shell = shell;
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public void addRegularToppings(String regularTopping) {
        regularToppings.add(regularTopping);
    }

    public void addSauce( String sauce) {
        sauces.add(sauce);
    }

    public void addSize(String size) {
        sides.add(size);
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void setCoveredInSalsaAndQueso(boolean coveredInSalsaAndQueso) {
        this.coveredInSalsaAndQueso = coveredInSalsaAndQueso;
    }

    public String getSize() {
        return size;
    }

    public String getShell() {
        return shell;
    }

    public String getMeat() {
        return meat;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public String getCheese() {
        return cheese;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public boolean isCoveredInSalsaAndQueso() {
        return coveredInSalsaAndQueso;
    }

    @Override
    public double getPrice() {
        double price = getBasePrice();

        if (meat != null) price += getMeatPrice();
        if (extraMeat) price += getExtraMeatPrice();
        if (cheese != null) price += getCheesePrice();
        if (extraCheese) price += getExtraCheesePrice();

        return price;
    }

    private double getBasePrice() {
        if (size.equalsIgnoreCase("Single Taco")){
            return 3.50;
        }
        if (size.equalsIgnoreCase("3-Taco Plate")) {
            return 9.00;
        }
        if (size.equalsIgnoreCase("Burrito")) {
            return 8.50;
        }
        return 0;
    }

    private double getMeatPrice() {
        if (size.equalsIgnoreCase("Single Taco")) {
            return 1.00;
        }
        if (size.equalsIgnoreCase("3-Taco Plate")) {
            return 2.00;
        }
        if (size.equalsIgnoreCase("Burrito")) {
            return 3.00;
        }
        return 0;
    }

    private double getExtraMeatPrice() {
        if (size.equalsIgnoreCase("Single Taco")) {
            return 0.50;
        }
        if (size.equalsIgnoreCase("3-Taco Plate")) {
            return 1.00;
        }
        if (size.equalsIgnoreCase("Burrito")) {
            return 1.50;
        }
        return 0;
    }

    private double getCheesePrice() {
        if (size.equalsIgnoreCase("Single Taco")) {
            return 0.75;
        }
        if (size.equalsIgnoreCase("3-Taco Plate")) {
            return 1.50;
        }
        if (size.equalsIgnoreCase("Burrito")) {
            return 2.25;
        }
        return 0;
    }

    private double getExtraCheesePrice() {
        if (size.equalsIgnoreCase("Single Taco")) {
            return 0.30;
        }
        if (size.equalsIgnoreCase("3-Taco Plate")) {
            return 0.60;
        }
        if (size.equalsIgnoreCase("Burrito")) {
            return 0.90;
        }
        return 0;
    }

}
