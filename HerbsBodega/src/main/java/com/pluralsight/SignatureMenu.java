package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class SignatureMenu {

    public static Sandwich chooseAndCustomizeSignatureSandwich(Scanner scanner) {
        System.out.println("\n--- Signature Sandwiches ---");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");
        System.out.println("0) Go Back");
        System.out.print("Choose a sandwich to customize: ");

        Sandwich sandwich = switch (scanner.nextLine()) {
            case "1" -> new BltSandwich();
            case "2" -> new PhillyCheeseSteakSandwich();
            default -> null;
        };

        if (sandwich == null) {
            System.out.println("Returning to previous menu.");
            return null;
        }

        System.out.println("\nYou've selected: " + sandwich.getName());
        displayToppings(sandwich);

        // Remove toppings
        promptRemoveToppings(scanner, sandwich);

        // Add new toppings
        List<Toppings> additional = SandwichBuilder.promptToppings(scanner, sandwich.getSize());
        for (Toppings t : additional) {
            sandwich.addTopping(t);
        }

        return sandwich;
    }

    private static void displayToppings(Sandwich sandwich) {
        System.out.println("Current toppings:");
        List<Toppings> toppings = sandwich.getToppings();
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println((i + 1) + ") " + toppings.get(i));
        }
    }

    private static void promptRemoveToppings(Scanner scanner, Sandwich sandwich) {
        while (true) {
            displayToppings(sandwich);
            System.out.print("Enter topping number to remove or 0 to continue: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) break;
                sandwich.getToppings().remove(choice - 1);
                System.out.println("Topping removed.");
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }
}