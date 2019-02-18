package com.example.springbootpattern.builder;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
