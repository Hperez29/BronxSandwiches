package com.pluralsight;

import java.util.Scanner;

public class ChipMenu {
    private String name;
    private double price;

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

        switch (choice) {
            case "1":
                return new ChipMenu("Classic Lays", 1.50);
            case "2":
                return new ChipMenu("Doritos", 1.75);
            case "3":
                return new ChipMenu("BBQ Chips", 1.60);
            case "4":
                return null; // No chips selected
            default:
                System.out.println("Invalid chip selection.");
                return null;
        }
    }
}