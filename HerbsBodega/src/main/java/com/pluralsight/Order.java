package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
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
        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            System.out.println("No items in order.");
            return;
        }

        if (!sandwiches.isEmpty()) {
            System.out.println("Sandwiches:");
            for (Sandwich s : sandwiches) {
                System.out.println("- " + s.getName());
            }
        }
        if (!drinks.isEmpty()) {
            System.out.println("Drinks:");
            for (DrinkMenu d : drinks) {
                System.out.println("- " + d.getName());
            }
        }
        if (!chips.isEmpty()) {
            System.out.println("Chips:");
            for (ChipMenu c : chips) {
                System.out.println("- " + c.getName());
            }
        }
    }

    public void saveReceipt() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String fileName = "receipt_" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("--- HerbsBodega Receipt ---\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n\n");

            double total = 0.0;

            if (!sandwiches.isEmpty()) {
                writer.write("Sandwiches:\n");
                for (Sandwich s : sandwiches) {
                    writer.write("- " + s.getName() + " - $" + String.format("%.2f", s.getPrice()) + "\n");
                    total = total + s.getPrice();
                }
                writer.write("\n");
            }

            if (!drinks.isEmpty()) {
                writer.write("Drinks:\n");
                for (DrinkMenu d : drinks) {
                    writer.write("- " + d.getName() + " - $" + String.format("%.2f", d.getPrice()) + "\n");
                    total += d.getPrice();
                }
                writer.write("\n");
            }

            if (!chips.isEmpty()) {
                writer.write("Chips:\n");
                for (ChipMenu c : chips) {
                    writer.write("- " + c.getName() + " - $" + String.format("%.2f", c.getPrice()) + "\n");
                    total += c.getPrice();
                }
                writer.write("\n");
            }

            writer.write("Total: $" + String.format("%.2f", total) + "\n");
            writer.write("\nThank you for visiting HerbsBodega!\n");

            System.out.println("Receipt saved as " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}