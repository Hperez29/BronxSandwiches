package com.pluralsight;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<DrinksMenu> drinksMenus = new ArrayList<>();
    private List<ChipsMenu> chips = new ArrayList<>();

    public void addSandwich(Sandwich s) {
        sandwiches.add(s);
    }

    public void addDrink(DrinksMenu d) {
        drinksMenus.add(d);
    }

    public void addChips(ChipsMenu c) {
        chips.add(c);
    }

    public double getTotalCost() {
        return sandwiches.stream().mapToDouble(Sandwich::calculateCost).sum() +
                drinksMenus.stream().mapToDouble(DrinksMenu::getCost).sum() +
                chips.stream().mapToDouble(ChipsMenu::getCost).sum();
    }

    public void displayOrder() {
        System.out.println("\n--- Order Details ---");
        for (Sandwich s : sandwiches) {
            System.out.println(s);
        }
        for (DrinksMenu d : drinksMenus) {
            System.out.println(d);
        }
        for (ChipsMenu c : chips) {
            System.out.println(c);
        }
        System.out.printf("Total: $%.2f\n", getTotalCost());
    }

    public void saveReceipt() {
        String filename = new SimpleDateFormat("yyyyMMdd-HHmmss'.txt'").format(new Date());
        File dir = new File("receipts");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (PrintWriter out = new PrintWriter(new File(dir, filename))) {
            for (Sandwich s : sandwiches) {
                out.println(s);
            }
            for (DrinksMenu d : drinksMenus) {
                out.println(d);
            }
            for (ChipsMenu c : chips) {
                out.println(c);
            }
            out.printf("Total: $%.2f\n", getTotalCost());
            System.out.println("Receipt saved as: receipts/" + filename);
        } catch (IOException e) {
            System.out.println("Failed to save receipt.");
        }
    }
}