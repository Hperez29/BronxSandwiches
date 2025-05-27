package com.pluralsight;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich s) { sandwiches.add(s); }
    public void addDrink(Drink d) { drinks.add(d); }
    public void addChips(Chips c) { chips.add(c); }

    public double getTotalCost() {
        return sandwiches.stream().mapToDouble(Sandwich::calculateCost).sum() +
                drinks.stream().mapToDouble(Drink::getCost).sum() +
                chips.stream().mapToDouble(Chips::getCost).sum();
    }

    public void displayOrder() {
        System.out.println("\n--- Order Details ---");
        sandwiches.forEach(System.out::println);
        drinks.forEach(System.out::println);
        chips.forEach(System.out::println);
        System.out.printf("Total: $%.2f\n", getTotalCost());
    }

    public void saveReceipt() {
        String filename = new SimpleDateFormat("yyyyMMdd-HHmmss'.txt'").format(new Date());
        File dir = new File("receipts");
        if (!dir.exists()) dir.mkdirs();
        try (PrintWriter out = new PrintWriter(new File(dir, filename))) {
            sandwiches.forEach(s -> out.println(s.toString()));
            drinks.forEach(d -> out.println(d.toString()));
            chips.forEach(c -> out.println(c.toString()));
            out.printf("Total: $%.2f\n", getTotalCost());
            System.out.println("Receipt saved as: receipts/" + filename);
        } catch (IOException e) {
            System.out.println("Failed to save receipt.");
        }
    }
}
