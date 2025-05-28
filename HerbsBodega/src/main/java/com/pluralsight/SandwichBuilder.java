package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {

    public static Sandwich build(Scanner scanner) {
        System.out.println("\n--- Build Your Sandwich ---");

        // Sandwich Size
        String size = promptSize(scanner);

        // Bread Type
        String bread = promptBread(scanner);

        // Toasted
        boolean toasted = promptToasted(scanner);

        // Toppings
        List<Toppings> toppings = promptToppings(scanner, size);

        return new Sandwich(size, bread, toasted, toppings);
    }

    private static String promptSize(Scanner scanner) {
        while (true) {
            System.out.print("Choose sandwich size (4, 8, 12): ");
            String size = scanner.nextLine();
            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                return size;
            }
            System.out.println("Invalid size. Please choose 4, 8, or 12.");
        }
    }

    private static String promptBread(Scanner scanner) {
        System.out.println("Choose bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        while (true) {
            System.out.print("Enter your choice: ");
            switch (scanner.nextLine()) {
                case "1" -> { return "White"; }
                case "2" -> { return "Wheat"; }
                case "3" -> { return "Rye"; }
                case "4" -> { return "Wrap"; }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    private static boolean promptToasted(Scanner scanner) {
        System.out.print("Would you like the sandwich toasted? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    private static List<Toppings> promptToppings(Scanner scanner, String size) {
        List<Toppings> toppings = new ArrayList<>();

        // Meats
        String[] meats = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        for (String meat : meats) {
            System.out.print("Add " + meat + "? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Extra " + meat + "? (y/n): ");
                boolean extra = scanner.nextLine().equalsIgnoreCase("y");
                toppings.add(new Meat(meat, extra));
            }
        }

        // Cheeses
        String[] cheeses = {"American", "Provolone", "Cheddar", "Swiss"};
        for (String cheese : cheeses) {
            System.out.print("Add " + cheese + " cheese? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Extra " + cheese + "? (y/n): ");
                boolean extra = scanner.nextLine().equalsIgnoreCase("y");
                toppings.add(new Cheese(cheese, extra));
            }
        }

        // Regular Toppings
        String[] regulars = {
                "Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños",
                "Cucumbers", "Pickles", "Guacamole", "Mushrooms"
        };
        for (String topping : regulars) {
            System.out.print("Add " + topping + "? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                toppings.add(new RegularTopping(topping));
            }
        }

        // Sauces
        String[] sauces = {
                "Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette", "Au Jus", "Sauce"
        };
        for (String sauce : sauces) {
            System.out.print("Add " + sauce + "? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                toppings.add(new RegularTopping(sauce));
            }
        }

        return toppings;
    }
}