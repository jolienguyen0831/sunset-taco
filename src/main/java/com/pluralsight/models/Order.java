package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public String getOrderSummary() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("""
                ========================================
                              ORDER SUMMARY
                ========================================
                """);
        int itemNumber = 1;
        for (int i = items.size() - 1; i >= 0; i--) {
            stringBuilder.append(String.format("\nItem #%s ", itemNumber));
            stringBuilder.append(items.get(i).toString());
            itemNumber++;
        }
        stringBuilder.append("_______________________________________\n");
        stringBuilder.append(String.format("SUBTOTAL    : $%.2f%n", getTotalPrice()));
        double tax = getTotalPrice() * 0.0825;
        stringBuilder.append(String.format("TAX (8.25%%) : $%.2f%n", tax));
        stringBuilder.append(String.format("TOTAL       : $%.2f%n", (getTotalPrice()+tax)));
        return stringBuilder.toString();
    }
    public ArrayList<Taco> getTacos(){
        ArrayList<Taco> tacos = new ArrayList<>();
        for(MenuItem item: items){
            if (item instanceof Taco){
                tacos.add((Taco)item);
            }
        }
        return tacos;
    }
    public ArrayList<Drink> getDrinks(){
        ArrayList<Drink> drinks = new ArrayList<>();
        for(MenuItem item: items){
            if (item instanceof Drink){
                drinks.add((Drink) item);
            }
        }
        return drinks;
    }

    public ArrayList<ChipsAndSalsa> getChipsAndSalsas(){
        ArrayList<ChipsAndSalsa> chipsAndSalsas = new ArrayList<>();
        for(MenuItem item: items){
            if (item instanceof ChipsAndSalsa){
                chipsAndSalsas.add((ChipsAndSalsa) item);
            }
        }
        return chipsAndSalsas;
    }

}
