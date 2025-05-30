package com.pluralsight;

import java.util.Scanner;

public class ChipMenu {
    private final String name;
    private final double price;

    public ChipMenu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static ChipMenu create(Scanner scanner) {
        System.out.println("\nChoose a chip:");
        System.out.println("1) Classic Lays - $1.50");
        System.out.println("2) Doritos - $1.75");
        System.out.println("3) BBQ Chips - $1.60");
        System.out.println("4) No Chips");

        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        return switch (choice) {
            case "1" -> new ChipMenu("Classic Lays", 1.50);
            case "2" -> new ChipMenu("Doritos", 1.75);
            case "3" -> new ChipMenu("BBQ Chips", 1.60);
            case "4" -> null; // No chips selected
            default -> {
                System.out.println("Invalid chip selection.");
                yield null;
            }
        };
    }
}