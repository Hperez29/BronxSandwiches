package com.pluralsight;

public class DrinkMenu {
    private final String name;
    private final double price;

    public DrinkMenu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}