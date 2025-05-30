package com.pluralsight;

public class Meat extends Topping {
    private boolean isExtra;

    public Meat(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;
    }

    @Override
    public double getPrice(int size) {
        if (isExtra) {
            switch (size) {
                case 4: return 0.50;
                case 8: return 1.00;
                case 12: return 1.50;
                default: return 0;
            }
        } else {
            switch (size) {
                case 4: return 1.00;
                case 8: return 2.00;
                case 12: return 3.00;
                default: return 0;
            }
        }
    }
}
