package com.iofit.creational.prototype;

import java.util.Objects;

public class Cellphone implements Cloneable {
    private Screen screen;
    private FingerprintReader fingerprintReader;
    private HeadphonesJack headphonesJack;
    private ServiceProviderChip serviceProviderChip;

    public Screen getScreen() {
        return screen;
    }

    public FingerprintReader getFingerprintReader() {
        return fingerprintReader;
    }

    public HeadphonesJack getHeadphonesJack() {
        return headphonesJack;
    }

    public ServiceProviderChip getServiceProviderChip() {
        return serviceProviderChip;
    }

    public Cellphone() {
        screen = new Screen();
        fingerprintReader = new FingerprintReader();
        headphonesJack = new HeadphonesJack();
        serviceProviderChip = new ServiceProviderChip();
    }

    @Override
    public Cellphone clone() {
        Cellphone cellphone = new Cellphone();
        cellphone.screen = screen.clone();
        cellphone.fingerprintReader = fingerprintReader.clone();
        cellphone.headphonesJack = headphonesJack.clone();
        return cellphone;
    }

}
