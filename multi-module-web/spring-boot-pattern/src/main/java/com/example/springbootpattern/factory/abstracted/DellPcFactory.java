package com.example.springbootpattern.factory.abstracted;

/**
 * Dell鼠标工厂，只生产dell鼠标
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class DellPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
