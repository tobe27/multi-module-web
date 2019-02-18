package com.example.springbootpattern.factory;

/**
 * Apple鼠标工厂，只生产Apple鼠标
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class AppleMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new AppleMouse();
    }
}
