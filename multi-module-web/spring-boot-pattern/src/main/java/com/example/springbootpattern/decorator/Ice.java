package com.example.springbootpattern.decorator;

/**
 * 冰，装饰用的
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public class Ice extends Condiment {

    public Ice(Drink drink) {
        super(drink);
    }

    @Override
    public String description() {
        return drink.description() + " + 冰";
    }


    @Override
    public double cost() {
        return drink.cost() + 1.0;
    }
}
