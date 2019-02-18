package com.example.springbootpattern.builder;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
