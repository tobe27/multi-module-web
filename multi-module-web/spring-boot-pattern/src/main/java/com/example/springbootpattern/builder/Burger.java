package com.example.springbootpattern.builder;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public abstract class Burger implements Item{
    @Override
    public Packing packing() {
        return new WrapperPacking();
    }

    @Override
    public abstract float price();
}
