package com.example.springbootpattern.strategy;

/**
 * @author CREATED BY L.C.Y on 2019-3-6
 */
public class Subtraction implements Strategy {
    /**
     * 计算方法-减法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
