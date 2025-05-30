package com.pluralsight;

public class Cheese extends Topping {
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int size) {
        double price;
        switch (size) {
            case 4: price = 0.75; break;
            case 8: price = 1.50; break;
            case 12: price = 2.25; break;
            default: price = 0; break;
        }
        if (isExtra) {
            price += (size == 4) ? 0.30 : (size == 8) ? 0.60 : 0.90;
        }
        return price;
    }
}