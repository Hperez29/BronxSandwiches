package com.pluralsight;

public class Topping {
    protected String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Price depends on sandwich size; overridden in subclasses
    public double getPrice(int size) {
        return 0.0; // default for included toppings
    }
}