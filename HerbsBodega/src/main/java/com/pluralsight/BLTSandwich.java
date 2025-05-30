package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class BLTSandwich extends Sandwich {

    public BLTSandwich() {
        super("BLT", "White", true, createToppings());
    }

    private static List<Topping> createToppings() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Meat("Bacon", false));         // Bacon, not extra
        toppings.add(new RegularTopping("Lettuce"));
        toppings.add(new RegularTopping("Tomatoes"));
        // Add other toppings if needed
        return toppings;
    }
}