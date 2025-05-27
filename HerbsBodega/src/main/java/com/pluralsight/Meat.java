package com.pluralsight;

public class Meat extends Topping {
    public Meat(String name, boolean extra) {
        super(name, extra);
    }

    public double getCost(String size) {
        double cost = switch (size) {
            case "4" -> 1.00;
            case "8" -> 2.00;
            case "12" -> 3.00;
            default -> 0;
        };
        return cost + (extra ? switch (size) {
            case "4" -> 0.50;
            case "8" -> 1.00;
            case "12" -> 1.50;
            default -> 0;
        } : 0);
    }
}
