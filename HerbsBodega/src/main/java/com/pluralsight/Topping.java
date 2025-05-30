package com.pluralsight;

public abstract class Topping {
    protected String name;
    protected boolean isExtra;

    public Topping(String name) {
        this(name, false);
    }

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    // Price depends on size and whether it's extra
    public abstract double getPrice(int size);
}