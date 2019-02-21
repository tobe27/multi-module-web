package com.example.springbootpattern.decorator;

/**
 * 需要装饰的类
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public class LemonTea implements Drink {

    @Override
    public String description() {
        return "柠檬茶";
    }

    @Override
    public double cost() {
        return 8.0;
    }
}
