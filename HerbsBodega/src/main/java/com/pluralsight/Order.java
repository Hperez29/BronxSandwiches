package com.pluralsight;

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
        // For now, just print confirmation.
        System.out.println("Order receipt saved (this is a stub).");
        // You can later implement file writing here.
    }
}