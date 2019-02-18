package com.example.springbootpattern.builder;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class WrapperPacking implements Packing {
    @Override
    public String pack() {
        return "Packed By Wrapper";
    }
}
