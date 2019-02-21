package com.example.springbootpattern.decorator;

/**
 * 糖，用来装饰
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public class Sugar extends Condiment {

    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public String description() {
        return drink.description() + " + 糖";
    }


    @Override
    public double cost() {
        return drink.cost() + 1.5;
    }
}
