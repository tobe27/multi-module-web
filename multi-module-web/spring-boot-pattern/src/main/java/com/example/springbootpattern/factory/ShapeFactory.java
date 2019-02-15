package com.example.springbootpattern.factory;

/**
 * 创建型模式-工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。
 * 它提供了一种创建对象的最佳方式。
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，
 * 并且是通过使用一个共同的接口来指向新创建的对象。
 * @author CREATED BY L.C.Y on 2019-2-15
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {

        if (shapeType == null || shapeType.isEmpty()) {
            return null;
        }

        // 正方形
        if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        // 三角形
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        // 圆形
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }

        return null;
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // 通过工厂模式获取圆形
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        // 通过工厂模式获取三角形
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        // 通过工厂模式获取正方形
        Shape square = shapeFactory.getShape("square");
        square.draw();
    }
}
