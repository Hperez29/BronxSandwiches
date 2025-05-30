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

    @Override
    public String toString() {
        return getDescription();
    }

    public double getPrice() {
        double basePrice;

        switch (size) {
            case 4:  basePrice = 5.50; break;  // updated bread prices from your list
            case 8:  basePrice = 7.00; break;
            case 12: basePrice = 8.50; break;
            default: basePrice = 0.0;
        }

        for (Topping topping : toppings) {
            basePrice += topping.getPrice(size);
        }

        return basePrice;
    }}