package com.pluralsight;

import java.util.Scanner;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public static Drink create(Scanner scanner) {
        System.out.print("Enter drink size (Small, Medium, Large): ");
        String size = scanner.nextLine();
        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }

    public double getCost() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return size + " " + flavor + " - $" + getCost();
    }
}
