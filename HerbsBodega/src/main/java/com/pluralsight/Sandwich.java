package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String name;
    private String breadType;
    private int size; // in inches: 4, 8, or 12
    private boolean toasted;
    private List<Topping> toppings;

    // Constructor
    public Sandwich(String name, int size, String breadType, boolean toasted, List<Topping> toppings) {
        this.name = name;
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = toppings != null ? toppings : new ArrayList<>();
    }

    public Sandwich(String size, String bread, boolean toasted, List<Topping> toppings) {
    }

    // Add a single topping
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Add multiple toppings at once
    public void addToppings(List<Topping> toppingsToAdd) {
        toppings.addAll(toppingsToAdd);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    // Calculate cost based on size and toppings
    public double calculateCost() {
        double basePrice;
        switch (size) {
            case 4 -> basePrice = 5.50;
            case 8 -> basePrice = 7.00;
            case 12 -> basePrice = 8.50;
            default -> basePrice = 0.0;
        }

        double toppingCost = 0.0;
        for (Topping t : toppings) {
            toppingCost += t.getCost(size);
        }

        return basePrice + toppingCost;
    }

    @Override
    public String toString() {
        return String.format("%d\" %s sandwich%s with: %s",
                size,
                breadType,
                toasted ? " (toasted)" : "",
                toppings.isEmpty() ? "no toppings" : toppings);
    }
}