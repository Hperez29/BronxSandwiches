package com.pluralsight;

import java.util.Scanner;

public class HerbsBodegaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to HerbsBodega ---");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> new OrderManager().startOrder(scanner);
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println("Thank you for visiting HerbsBodega!");
        scanner.close();
    }
}