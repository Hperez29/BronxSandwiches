package com.pluralsight;

import java.util.Scanner;

public class ChipMenu {
    private String name;

    public ChipMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ChipMenu create(Scanner scanner) {
        System.out.println("Choose chips:");
        System.out.println("1) Lay's");
        System.out.println("2) Doritos");
        System.out.println("3) SunChips");
        System.out.print("Enter choice (or 0 to cancel): ");
        String input = scanner.nextLine();
        switch (input) {
            case "1": return new ChipMenu("Lay's");
            case "2": return new ChipMenu("Doritos");
            case "3": return new ChipMenu("SunChips");
            case "0": return null;
            default:
                System.out.println("Invalid choice.");
                return null;
        }
    }
}