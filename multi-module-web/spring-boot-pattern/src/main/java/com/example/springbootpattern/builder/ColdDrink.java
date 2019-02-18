package com.example.springbootpattern.builder;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new BottlePacking();
    }

    @Override
    public abstract float price() ;
}
