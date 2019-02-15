package com.example.springbootpattern.factory;

/**
 * 圆形实现了Shape
 * @author CREATED BY L.C.Y on 2019-2-15
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形实现了Shape");
    }
}
