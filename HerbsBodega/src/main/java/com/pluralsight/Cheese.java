package com.pluralsight;

public class Cheese extends Topping {
    private boolean isExtra;

    public Cheese(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;
    }

    @Override
    public double getPrice(int size) {
        if (isExtra) {
            switch (size) {
                case 4: return 0.30;
                case 8: return 0.60;
                case 12: return 0.90;
                default: return 0;
            }
        } else {
            switch (size) {
                case 4: return 0.75;
                case 8: return 1.50;
                case 12: return 2.25;
                default: return 0;
            }
        }
    }
}