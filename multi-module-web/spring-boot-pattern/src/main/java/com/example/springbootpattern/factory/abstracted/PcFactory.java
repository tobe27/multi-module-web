package com.example.springbootpattern.factory.abstracted;

/**
 * 创建型模式-抽象工厂模式
 * 抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂
 * 当产品只有一个的时候，抽象工厂模式即为工厂模式，反之亦然
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public interface PcFactory {
    Mouse createMouse();
    Keyboard createKeyboard();

    public static void main(String[] args) {
        // PC工厂= Apple PC工厂
        PcFactory applePcFactory = new ApplePcFactory();
        Mouse appleMouse = applePcFactory.createMouse();
        Keyboard appleKeyboard = applePcFactory.createKeyboard();
        System.out.println(appleMouse.doubleClick());
        System.out.println(appleKeyboard.knock());


        // PC工厂= Dell PC工厂
        PcFactory dellPcFactory = new DellPcFactory();
        Mouse dellMouse = dellPcFactory.createMouse();
        Keyboard dellKeyboard = dellPcFactory.createKeyboard();
        System.out.println(dellMouse.doubleClick());
        System.out.println(dellKeyboard.knock());
    }
}
