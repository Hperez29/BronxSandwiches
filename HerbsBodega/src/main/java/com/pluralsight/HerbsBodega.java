package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HerbsBodega {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("--- Welcome to HerbsBodega ---");

        do {
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Order order = new Order();
                    System.out.println("Starting new order...");

                    // === Build Sandwich ===
                    System.out.print("Enter sandwich name: ");
                    String sandwichName = scanner.nextLine();

                    System.out.print("Choose bread (White, Wheat, Sourdough): ");
                    String bread = scanner.nextLine();

                    System.out.print("Enter size (4, 8, or 12 inches): ");
                    int size = Integer.parseInt(scanner.nextLine());

                    System.out.print("Toasted? (yes/no): ");
                    boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

                    // Toppings selection (basic example)
                    List<Topping> toppings = new ArrayList<>();
                    System.out.println("Add toppings (type 'done' when finished):");
                    while (true) {
                        System.out.print("Topping: ");
                        String toppingInput = scanner.nextLine();
                        if (toppingInput.equalsIgnoreCase("done")) break;
                        toppings.add(new Topping(toppingInput));  // assumes Topping class has constructor with name
                    }

                    Sandwich sandwich = new Sandwich(sandwichName, size, bread, toasted, toppings);
                    order.addSandwich(sandwich);

                    // === Add Drink ===
                    System.out.print("Add a drink? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        System.out.print("Drink name: ");
                        String drinkName = scanner.nextLine();
                        System.out.print("Drink price: ");
                        double drinkPrice = Double.parseDouble(scanner.nextLine());
                        order.addDrink(new DrinkMenu(drinkName, drinkPrice));
                    }

                    // === Add Chips ===
                    System.out.print("Add chips? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        System.out.print("Chip flavor: ");
                        String chipName = scanner.nextLine();
                        System.out.print("Chip price: ");
                        double chipPrice = Double.parseDouble(scanner.nextLine());
                        order.addChips(new ChipMenu(chipName, chipPrice));
                    }

                    // === Show Order and Save ===
                    order.displayOrder();
                    order.saveReceipt();
                    break;

                case 0:
                    System.out.println("Thank you for visiting HerbsBodega!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}