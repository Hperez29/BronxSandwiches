package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String bread;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(String size, String bread, boolean toasted, List<Topping> toppings) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = toppings;
    }

    public double calculateCost() {
        double base = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0;
        };

        double toppingsCost = 0;
        for (Topping t : toppings) {
            toppingsCost += t.getCost(size);
        }

        return base + toppingsCost;
    }

    @Override
    public String toString() {
        return size + "\" " + bread + (toasted ? " (Toasted)" : "") + "\nToppings:\n" +
                toppings.stream().map(Topping::toString).reduce("", (a, b) -> a + b + "\n");
    }
}