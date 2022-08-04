package com.iofit.creational.factory;

import com.iofit.exceptions.NotAvailableCarException;

public class CarFactory {
    private static CarFactory instance;

    private CarFactory() {}
    public static CarFactory getInstance() {
        synchronized (CarFactory.class){
            if(instance == null) {
                instance =new CarFactory();
            }
        }
        return instance;
    }

    public Car buildCar(Cars carType) throws NotAvailableCarException {
        return switch (carType) {
            case FORD -> new Ford();
            case CHEVY -> throw new NotAvailableCarException();
            case VOLKSWAGEN -> new Volkswagen();
        };
    }
}

