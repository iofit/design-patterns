package com.iofit.creational.abstractfactory.windows;

import com.iofit.creational.abstractfactory.*;

public class WindowsComputerFactory extends AbstractComputerFactory {
    @Override
    public Laptop createLaptop() {
        return new WindowsLaptop();
    }

    @Override
    public Mouse createMouse() {
        return new WindowsMouse();
    }

    @Override
    public MousePad createMousePad() {
        return new SimpleMousePad();
    }

    @Override
    public Keyboard createKeyboard() {
        return new WindowsKeyboard();
    }
}
