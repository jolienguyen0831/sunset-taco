package com.pluralsight.models;

public class StreetTaco extends Taco{
    public StreetTaco(){
        super("3-Taco Plate","Corn");
        this.meat = "Carne Asada";
        this.cheese ="";
        this.addRegularToppings("Onions");
        this.addRegularToppings("Cilantro");
        this.addSauce("Salsa Verde");
        this.addSide("Lime Wedges");

    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString(){
        return " Street Taco (Signature)\n" + super.toString();
    }
}
