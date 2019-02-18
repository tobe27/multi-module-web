package com.example.springbootpattern.factory.abstracted;

/**
 * Apple鼠标工厂，只生产Apple鼠标
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class ApplePcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new AppleMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new AppleKeyboard();
    }
}
