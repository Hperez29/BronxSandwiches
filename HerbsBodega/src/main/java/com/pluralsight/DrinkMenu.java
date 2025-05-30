package com.pluralsight;

import java.util.Scanner;

public class DrinkMenu {
    private String name;
    private double price;

    public DrinkMenu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static DrinkMenu chooseDrink(Scanner scanner) {
        System.out.println("\nChoose a drink:");
        System.out.println("1) Coke - $1.99");
        System.out.println("2) Sprite - $1.99");
        System.out.println("3) Water - $1.50");
        System.out.println("4) No Drink");

        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                return new DrinkMenu("Coke", 1.99);
            case "2":
                return new DrinkMenu("Sprite", 1.99);
            case "3":
                return new DrinkMenu("Water", 1.50);
            case "4":
                return null;
            default:
                System.out.println("Invalid drink selection.");
                return null;
        }
    }
}