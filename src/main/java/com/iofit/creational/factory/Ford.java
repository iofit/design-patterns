package com.iofit.creational.factory;

public class Ford implements Car {

    @Override
    public void accelerate() {
        System.out.println("Ford accelerating!");
    }

    @Override
    public int getMileage() {
        return 100123;
    }

    @Override
    public String getMaker() {
        return "Ford";
    }

    @Override
    public int getYear() {
        return 2000;
    }
}
