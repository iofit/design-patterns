package com.iofit.creational.abstractfactory.arm;

import com.iofit.creational.abstractfactory.*;
import com.iofit.creational.abstractfactory.windows.WindowsKeyboard;
import com.iofit.creational.abstractfactory.windows.WindowsMouse;

public class ARMComputerFactory extends AbstractComputerFactory {
    @Override
    public Laptop createLaptop() {
        return new ARMLaptop();
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
