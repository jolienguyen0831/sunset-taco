package com.pluralsight.models;

import java.util.ArrayList;

import java.util.List;

import java.util.stream.Collectors;

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
    public List<Taco> getTacos(){
        return items.stream()
                .filter(item -> item instanceof Taco)
                .map(item -> (Taco) item)
                .collect(Collectors.toList());
    }
    public List<Drink> getDrinks() {
        return items.stream()
                .filter(item -> item instanceof Drink)
                .map(item -> (Drink) item)
                .collect(Collectors.toList());
    }

    public List<ChipsAndSalsa> getChipsAndSalsas() {
        return items.stream()
                .filter(item -> item instanceof ChipsAndSalsa)
                .map(item -> (ChipsAndSalsa) item)
                .collect(Collectors.toList());
    }

}
