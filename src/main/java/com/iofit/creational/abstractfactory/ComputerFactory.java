package com.iofit.creational.abstractfactory;

public interface ComputerFactory {
    Laptop createLaptop();
    Mouse createMouse();
    MousePad createMousePad();
    Keyboard createKeyboard();
}
