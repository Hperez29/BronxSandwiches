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

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<DrinkMenu> getDrinks() {
        return drinks;
    }

    public List<ChipMenu> getChips() {
        return chips;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (DrinkMenu d : drinks) total += d.getPrice();
        for (ChipMenu c : chips) total += c.getPrice();
        return total;
    }

    public void displayOrder() {
        System.out.println("--- Current Order ---");

        for (Sandwich sandwich : sandwiches) {
            System.out.printf("%s (%d inch) - $%.2f%n", sandwich.getName(), sandwich.getSize(), sandwich.getPrice());
            System.out.println("Toppings:");
            for (Topping topping : sandwich.getToppings()) {
                System.out.printf("  - %s: $%.2f%n", topping.getName(), topping.getPrice(sandwich.getSize()));
            }
        }

        for (DrinkMenu drink : drinks) {
            System.out.printf("Drink: %s - $%.2f%n", drink.getName(), drink.getPrice());
        }

        for (ChipMenu chip : chips) {
            System.out.printf("Chips: %s - $%.2f%n", chip.getName(), chip.getPrice());
        }

        System.out.printf("Total Price: $%.2f%n", calculateTotalPrice());
    }

    public Object saveReceipt() {
    return null;
    }

    // Add saveReceipt() method as needed
}