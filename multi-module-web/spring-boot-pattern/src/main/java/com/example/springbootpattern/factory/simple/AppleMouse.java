package com.example.springbootpattern.factory.simple;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class AppleMouse implements Mouse {
    @Override
    public String doubleClick() {
        return "Double Click 666 By Apple Mouse ";
    }
}
