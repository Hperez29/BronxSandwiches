package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    protected String name;
    protected String breadType;
    protected int size;
    protected boolean isToasted;
    protected List<Topping> toppings;

    public Sandwich(String name, String breadType, boolean isToasted, List<Topping> toppings) {
        this.name = name;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = (toppings != null) ? toppings : new ArrayList<>();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return name + " sandwich (" + size + " inch, " + breadType + (isToasted ? ", toasted" : ", not toasted")
                + ") with: " + getToppingsString();
    }

    private String getToppingsString() {
        if (toppings.isEmpty()) return "no toppings";
        StringBuilder sb = new StringBuilder();
        for (Topping topping : toppings) {
            sb.append(topping.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2); // Remove last comma and space
    }

    public double getPrice() {
        double basePrice = switch (breadType.toLowerCase()) {
            case "white", "wheat", "rye", "wrap" -> switch (size) {
                case 4 -> 5.50;
                case 8 -> 7.00;
                case 12 -> 8.50;
                default -> 0;
            };
            default -> 0;
        };

        // Bread prices based on breadType and size

        // Add toppings prices
        for (Topping topping : toppings) {
            basePrice += topping.getPrice(size);
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return getDescription() + String.format(" - $%.2f", getPrice());
    }
}