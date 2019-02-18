package com.example.springbootpattern.factory;

/**
 * Dell鼠标工厂，只生产dell鼠标
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
