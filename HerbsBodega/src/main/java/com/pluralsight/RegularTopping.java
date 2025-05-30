package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(int size) {
        // Regular toppings and sauces are included (no extra cost)
        return 0.0;
    }
}

