package com.pluralsight;

import java.util.ArrayList;

public class BltSandwich extends Sandwich {

    public BltSandwich() {
        super("8", "White", true, new ArrayList<>());

        // Default BLT toppings
        this.addTopping(new Meat("Bacon", false));
        this.addTopping(new Cheese("Cheddar", false));
        this.addTopping(new RegularTopping("Lettuce"));
        this.addTopping(new RegularTopping("Tomato"));
        this.addTopping(new RegularTopping("Ranch"));
    }

    @Override
    public String getName() {
        return "BLT";
    }
}