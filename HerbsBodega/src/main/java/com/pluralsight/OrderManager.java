package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private Order currentOrder = new Order();

    public void startOrder(Scanner scanner) {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> currentOrder.addSandwich(SandwichBuilder.build(scanner));
                case 2 -> currentOrder.addDrink(Drink.create(scanner));
                case 3 -> currentOrder.addChips(Chips.create(scanner));
                case 4 -> {
                    currentOrder.displayOrder();
                    System.out.print("Confirm order? (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        currentOrder.saveReceipt();
                        ordering = false;
                    } else {
                        System.out.println("Order canceled.");
                        currentOrder = new Order();
                        ordering = false;
                    }
                }
                case 0 -> {
                    System.out.println("Order canceled.");
                    ordering = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}