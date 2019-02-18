package com.example.springbootpattern.builder;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "CocaCola";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
