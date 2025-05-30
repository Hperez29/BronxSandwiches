package com.pluralsight;

public class Meat extends Topping {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int size) {
        double price;
        switch (size) {
            case 4: price = 1.00; break;
            case 8: price = 2.00; break;
            case 12: price = 3.00; break;
            default: price = 0; break;
        }
        if (isExtra) {
            price += (size == 4) ? 0.50 : (size == 8) ? 1.00 : 1.50;
        }
        return price;
    }
}