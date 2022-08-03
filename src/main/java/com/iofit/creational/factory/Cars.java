package com.iofit.creational.factory;

public enum Cars {
    VOLKSWAGEN("Volkswagen"), FORD("Ford"), CHEVY("Chevrolet");

    private String name;

    Cars(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
