package com.pluralsight;

public class Topping {
    private String name;
    private boolean isPremium;
    private boolean isExtra;

    public Topping(String name) {
        this.name = name;
    }

    public Topping(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public double getCost(int sandwichSize) {
        if (!isPremium) return 0.0;

        double cost = switch (name.toLowerCase()) {
            case "steak", "ham", "salami", "roast beef", "chicken", "bacon" -> switch (sandwichSize) {
                case 4 -> 1.00;
                case 8 -> 2.00;
                case 12 -> 3.00;
                default -> 0.0;
            };
            case "american", "cheddar", "provolone", "swiss" -> switch (sandwichSize) {
                case 4 -> 0.75;
                case 8 -> 1.50;
                case 12 -> 2.25;
                default -> 0.0;
            };
            default -> 0.0;
        };

        // Extra adds additional cost
        if (isExtra) {
            cost += switch (name.toLowerCase()) {
                case "steak", "ham", "salami", "roast beef", "chicken", "bacon" -> switch (sandwichSize) {
                    case 4 -> 0.50;
                    case 8 -> 1.00;
                    case 12 -> 1.50;
                    default -> 0.0;
                };
                case "american", "cheddar", "provolone", "swiss" -> switch (sandwichSize) {
                    case 4 -> 0.30;
                    case 8 -> 0.60;
                    case 12 -> 0.90;
                    default -> 0.0;
                };
                default -> 0.0;
            };
        }

        return cost;
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }
}