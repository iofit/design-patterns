package com.iofit.creational.factory;

public class Volkswagen implements Car {

    @Override
    public void accelerate() {
        System.out.println("VW accelerating!");
    }

    @Override
    public int getMileage() {
        return 12301;
    }

    @Override
    public String getMaker() {
        return "Volkswagen";
    }

    @Override
    public int getYear() {
        return 2021;
    }
}
