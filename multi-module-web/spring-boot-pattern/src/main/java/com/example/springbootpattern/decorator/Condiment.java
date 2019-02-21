package com.example.springbootpattern.decorator;

/**
 * 调料
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public abstract class Condiment implements Drink {
    protected Drink drink;
    public Condiment(Drink drink) {
        this.drink = drink;
    }

    // 描述
    public abstract String description();

    // 花费
    public abstract double cost();

}
