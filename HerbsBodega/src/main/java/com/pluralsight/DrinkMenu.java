package com.pluralsight;

import java.util.Scanner;

public class DrinkMenu {
    private String name;

    public DrinkMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DrinkMenu chooseDrink(Scanner scanner) {
        System.out.println("Choose a drink:");
        System.out.println("1) Coke");
        System.out.println("2) Sprite");
        System.out.println("3) Water");
        System.out.print("Enter choice (or 0 to cancel): ");
        String input = scanner.nextLine();
        switch (input) {
            case "1": return new DrinkMenu("Coke");
            case "2": return new DrinkMenu("Sprite");
            case "3": return new DrinkMenu("Water");
            case "0": return null;
            default:
                System.out.println("Invalid choice.");
                return null;
        }
    }
}