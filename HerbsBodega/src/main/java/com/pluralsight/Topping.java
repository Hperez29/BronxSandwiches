package com.pluralsight;

public abstract class Topping {
    protected String name;
    protected boolean extra;

    public Topping(String name, boolean extra) {
        this.name = name;
        this.extra = extra;
    }

    public abstract double getCost(String size);

    @Override
    public String toString() {
        return name + (extra ? " (Extra)" : "");
    }
}

