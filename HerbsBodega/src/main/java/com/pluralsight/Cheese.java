package com.pluralsight;

public class Cheese extends Topping {
    public Cheese(String name, boolean extra) {
        super(name, extra);
    }

    public double getCost(String size) {
        double cost = switch (size) {
            case "4" -> 0.75;
            case "8" -> 1.50;
            case "12" -> 2.25;
            default -> 0;
        };
        return cost + (extra ? switch (size) {
            case "4" -> 0.30;
            case "8" -> 0.60;
            case "12" -> 0.90;
            default -> 0;
        } : 0);
    }
}
