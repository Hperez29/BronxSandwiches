package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<DrinkMenu> drinks = new ArrayList<>();
    private final List<ChipMenu> chips = new ArrayList<>();

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

    public void saveReceipt(String directoryPath) {
        if (directoryPath == null || directoryPath.isEmpty()) {
            directoryPath = System.getProperty("user.dir"); // Use current directory if none provided
        }

        // Validate the directory path
        try {
            Paths.get(directoryPath); // This will throw InvalidPathException if the path is invalid
        } catch (InvalidPathException e) {
            System.out.println("Invalid directory path: " + directoryPath);
            return;
        }

        String filename = "HerbsBodega_Receipt_" + System.currentTimeMillis() + ".txt";
        File file = new File(directoryPath, filename);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("--- HerbsBodega Receipt ---\n\n");

            if (!sandwiches.isEmpty()) {
                writer.write("Sandwiches:\n");
                for (Sandwich s : sandwiches) {
                    writer.write(String.format("- %s : $%.2f\n", s.getDescription(), s.getPrice()));
                }
                writer.write("\n");
            }

            if (!drinks.isEmpty()) {
                writer.write("Drinks:\n");
                for (DrinkMenu d : drinks) {
                    writer.write(String.format("- %s : $%.2f\n", d.getName(), d.getPrice()));
                }
                writer.write("\n");
            }

            if (!chips.isEmpty()) {
                writer.write("Chips:\n");
                for (ChipMenu c : chips) {
                    writer.write(String.format("- %s : $%.2f\n", c.getName(), c.getPrice()));
                }
                writer.write("\n");
            }

            writer.write(String.format("Total: $%.2f\n", calculateTotal()));
            writer.write("\nThank you for your order!\n");

            System.out.println("Receipt saved as " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}