package com.example.springbootpattern.factory;

/**
 * 正方形实现shape
 * @author CREATED BY L.C.Y on 2019-2-15
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("正方形实现了Shape");
    }
}
