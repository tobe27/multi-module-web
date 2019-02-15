package com.example.springbootpattern.factory;

/**
 * 三角形实现了Shape
 * @author CREATED BY L.C.Y on 2019-2-15
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("三角形实现了Shape");
    }
}
