package com.example.springbootpattern.factory;

/**
 * 创建型模式-工厂模式
 * 工厂是一个父类（只提供创建对象的接口），不涉及具体实现，而由其子类实现
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类，使一个类的实例化延迟到子类
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public interface MouseFactory {
    Mouse createMouse();

    public static void main(String[] args) {
        MouseFactory appleMouseFactory = new AppleMouseFactory();
        Mouse apple = appleMouseFactory.createMouse();
        System.out.println(apple.doubleClick());

        MouseFactory dellMouseFactory = new DellMouseFactory();
        Mouse dell = dellMouseFactory.createMouse();
        System.out.println(dell.doubleClick());
    }
}
