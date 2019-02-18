package com.example.springbootpattern.factory.simple;

/**
 * 创建型模式-简单工厂模式，不属于23种模式。
 * 生产一种品类，工厂直接生产产品
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class MouseFactory{

    public Mouse createMouse(String brand) {

        if ("Apple".equalsIgnoreCase(brand)) {
            return new AppleMouse();
        }

        if ("Dell".equalsIgnoreCase(brand)) {
            return new DellMouse();
        }

        return null;
    }

    public static void main(String[] args) {
        MouseFactory mouseFactory = new MouseFactory();

        Mouse apple = mouseFactory.createMouse("apple");
        System.out.println(apple.doubleClick());

        Mouse dell = mouseFactory.createMouse("dell");
        System.out.println(dell.doubleClick());
    }
}
