package com.example.springbootpattern.factory.abstracted;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class DellMouse implements Mouse {
    @Override
    public String doubleClick() {
        return "Double Click 666 By Dell Mouse ";
    }
}
