package com.iofit.creational.prototype;

public class FingerprintReader {

    private String model = "ASX-123";

    @Override
    public FingerprintReader clone() {
        FingerprintReader fingerprintReader = new FingerprintReader();
        fingerprintReader.model = this.model;
        return fingerprintReader;
    }
}
