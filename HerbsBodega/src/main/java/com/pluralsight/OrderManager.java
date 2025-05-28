package com.pluralsight;

import java.util.Scanner;

public class OrderManager {


    public void startOrder(Scanner scanner) {
        Order currentOrder = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- HerbsBodega POS ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order / Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\n1) Build Your Own\n2) Signature Sandwich");
                    String subChoice = scanner.nextLine();

                    Sandwich sandwich = null;
                    if (subChoice.equals("1")) {
                        sandwich = SandwichBuilder.build(scanner);
                    } else if (subChoice.equals("2")) {
                        sandwich = SignatureMenu.chooseAndCustomizeSignatureSandwich(scanner);
                    } else {
                        System.out.println("Invalid choice.");
                        break;
                    }

                    if (sandwich != null) {
                        currentOrder.addSandwich(sandwich);
                        System.out.println(sandwich.getName() + " added to order.");
                    }
                    break;

                case "2":
                    DrinkMenu drinkMenu = DrinkMenu.chooseDrink(scanner);
                    if (drinkMenu != null) {
                        currentOrder.addDrink(drinkMenu);
                        System.out.println(drinkMenu.getName() + " added to order.");
                    }
                    break;

                case "3":
                    ChipMenu chips = ChipMenu.create(scanner);
                    if (chips != null) {
                        currentOrder.addChips(chips);
                        System.out.println(chips.getName() + " added to order.");
                    }
                    break;

                case "4":
                    currentOrder.displayOrder();
                    System.out.println("1) Confirm and Save\n0) Cancel Order");
                    String confirm = scanner.nextLine();
                    if (confirm.equals("1")) {
                        currentOrder.saveReceipt();
                        ordering = false;
                    } else {
                        System.out.println("Order cancelled.");
                        ordering = false;
                    }
                    break;

                case "0":
                    System.out.println("Order cancelled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}