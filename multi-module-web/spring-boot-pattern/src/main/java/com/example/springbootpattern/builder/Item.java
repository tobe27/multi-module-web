package com.example.springbootpattern.builder;

/**
 * 食物条目
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public interface Item {
    String name();
    Packing packing();
    float price();
}
