package com.iofit.creational.abstractfactory.apple;

import com.iofit.creational.abstractfactory.*;

public class AppleComputerFactory extends AbstractComputerFactory {
    @Override
    public Laptop createLaptop() {
        return new MacbookPro();
    }

    @Override
    public Mouse createMouse() {
        return new MagicMouse();
    }

    @Override
    public MousePad createMousePad() {
        return new SimpleMousePad();
    }

    @Override
    public Keyboard createKeyboard() {
        return new AppleKeyboard();
    }
}
