package com.pluralsight.models;

import java.awt.*;
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
            System.out.println(items.get(i));
        }
        System.out.println("____________________________________");
        System.out.printf("TOTAL : $%.2f%n", getTotalPrice());
    }


}
