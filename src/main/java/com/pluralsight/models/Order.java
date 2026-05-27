package com.pluralsight.models;

import java.awt.*;
import java.sql.SQLOutput;
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

    public void getOrderSummary() {
        System.out.println("""
                ========================================
                              ORDER SUMMARY
                ========================================
                """);
        for (int i = items.size() - 1; i >= 0; i--) {
            System.out.println(items.get(i).toString());
        }
        System.out.println("_______________________________________");
        System.out.printf("SUBTOTAL : $%.2f%n", getTotalPrice());
        double tax = getTotalPrice() * 0.0825;
        System.out.printf("TAX (8.25%%): $%.2f%n", tax);
        System.out.printf("TOTAL : $%.2f%n", (getTotalPrice()+tax));
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

}
