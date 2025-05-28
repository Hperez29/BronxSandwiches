package com.pluralsight;

import java.util.Scanner;

public class ChipsMenu {
    private String type;

    public ChipsMenu(String type) {
        this.type = type;
    }

    public static ChipsMenu create(Scanner scanner) {
        System.out.print("Enter chip type: ");
        return new ChipsMenu(scanner.nextLine());
    }

    public double getCost() {
        return 1.50;
    }

    @Override
    public String toString() {
        return type + " - $1.50";


    }}