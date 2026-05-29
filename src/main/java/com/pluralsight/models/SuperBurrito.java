package com.pluralsight.models;

public class SuperBurrito extends Taco{
    public SuperBurrito(){
        super("Burrito","Flour");
        this.meat = "Carnitas";
        this.cheese = "Cheddar";
        this.addRegularToppings("Pico de Gallo");
        this.addRegularToppings("Lettuce");
        this.addRegularToppings("Tomatoes");
        this.coveredInSalsaAndQueso = true;

    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString(){
        return " Super Burrito (Signature)\n" + super.toString();
    }
}
