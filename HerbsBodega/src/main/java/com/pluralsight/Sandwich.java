package com.pluralsight;

import java.util.*;

public class Sandwich {
    private String name;
    private String breadType;
    private int size; // in inches: 4, 8, or 12
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public class Sandwich {
        private String size;
        private boolean toasted;
        // other fields...

        public Sandwich(String size, String bread, boolean toasted, List<Topping> toppings) {
            this.size = size;
            this.bread = bread;
            this.toasted = toasted;
            this.topping = toppings;

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Optional: for adding multiple toppings at once
    public void addToppings(List<Topping> toppingsToAdd) {
        toppings.addAll(toppingsToAdd);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public double calculateCost() {
        double basePrice;
        switch (size) {
            case 4 -> basePrice = 5.50;
            case 8 -> basePrice = 7.00;
            case 12 -> basePrice = 8.50;
            default -> basePrice = 0;
        }

        double toppingCost = 0;
        for (Topping t : toppings) {
            toppingCost += t.getCost(size);
        }

        return basePrice + toppingCost;
    }

    @Override
    public String toString() {
        return String.format("%d\" %s sandwich%s with: %s",
                size, breadType, toasted ? " (toasted)" : "",
                toppings.isEmpty() ? "no toppings" : toppings);
    }
}
