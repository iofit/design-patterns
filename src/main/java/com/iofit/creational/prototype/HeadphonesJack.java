package com.iofit.creational.prototype;

public class HeadphonesJack implements Cloneable{

    @Override
    public HeadphonesJack clone() {
        return new HeadphonesJack();
    }
}
