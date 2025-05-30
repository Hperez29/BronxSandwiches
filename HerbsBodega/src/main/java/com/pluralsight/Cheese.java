package com.pluralsight;

public class Cheese extends Topping {
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int size) {
        double price = switch (size) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0;
        };
        if (isExtra) {
            price += (size == 4) ? 0.30 : (size == 8) ? 0.60 : 0.90;
        }
        return price;
    }
}