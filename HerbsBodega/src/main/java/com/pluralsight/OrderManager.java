package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<DrinkMenu> drinks = new ArrayList<>();
    private List<ChipMenu> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(DrinkMenu drink) {
        drinks.add(drink);
    }

    public void addChips(ChipMenu chip) {
        chips.add(chip);
    }

    public void displayOrder() {
        System.out.println("\n--- Current Order ---");

        if (!sandwiches.isEmpty()) {
            System.out.println("Sandwiches:");
            for (Sandwich s : sandwiches) {
                System.out.printf("- %s : $%.2f\n", s.getDescription(), s.getPrice());
            }
        }

        if (!drinks.isEmpty()) {
            System.out.println("Drinks:");
            for (DrinkMenu d : drinks) {
                System.out.printf("- %s : $%.2f\n", d.getName(), d.getPrice());
            }
        }

        if (!chips.isEmpty()) {
            System.out.println("Chips:");
            for (ChipMenu c : chips) {
                System.out.printf("- %s : $%.2f\n", c.getName(), c.getPrice());
            }
        }

        System.out.printf("Total: $%.2f\n", calculateTotal());
    }

    public double calculateTotal() {
        double total = 0;
        for (Sandwich s : sandwiches) {
            total += s.getPrice();
        }
        for (DrinkMenu d : drinks) {
            total += d.getPrice();
        }
        for (ChipMenu c : chips) {
            total += c.getPrice();
        }
        return total;
    }

    public void saveReceipt() {
        String filename = "HerbsBodega_Receipt_" + System.currentTimeMillis() + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("--- HerbsBodega Receipt ---\n");

            if (!sandwiches.isEmpty()) {
                writer.write("Sandwiches:\n");
                for (Sandwich s : sandwiches) {
                    writer.write(String.format("- %s : $%.2f\n", s.getDescription(), s.getPrice()));
                }
            }

            if (!drinks.isEmpty()) {
                writer.write("Drinks:\n");
                for (DrinkMenu d : drinks) {
                    writer.write(String.format("- %s : $%.2f\n", d.getName(), d.getPrice()));
                }
            }

            if (!chips.isEmpty()) {
                writer.write("Chips:\n");
                for (ChipMenu c : chips) {
                    writer.write(String.format("- %s : $%.2f\n", c.getName(), c.getPrice()));
                }
            }

            writer.write(String.format("Total: $%.2f\n", calculateTotal()));
            writer.write("Thank you for your order!\n");
            System.out.println("Receipt saved as " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}