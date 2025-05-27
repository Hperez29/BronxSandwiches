package com.pluralsight;

import java.util.Scanner;

public class Chips {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    public static Chips create(Scanner scanner) {
        System.out.print("Enter chip type: ");
        return new Chips(scanner.nextLine());
    }

    public double getCost() {
        return 1.50;
    }

    @Override
    public String toString() {
        return type + " - $1.50";


    }}