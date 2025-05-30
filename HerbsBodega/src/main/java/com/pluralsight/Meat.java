package com.pluralsight;

public class Meat extends Topping {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int size) {
        double price = switch (size) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0;
        };
        if (isExtra) {
            price += (size == 4) ? 0.50 : (size == 8) ? 1.00 : 1.50;
        }
        return price;
    }
}