package com.pluralsight;

public class PhillyCheeseSteakSandwich extends Sandwich {

    public PhillyCheeseSteakSandwich() {
        super("8", "White", true, new ArrayList<>());

        // Default toppings
        this.addTopping(new Meat("Steak", false));
        this.addTopping(new Cheese("American", false));
        this.addTopping(new RegularTopping("Peppers"));
        this.addTopping(new RegularTopping("Mayo"));
    }

    @Override
    public String getName() {
        return "Philly Cheese Steak";
    }
}