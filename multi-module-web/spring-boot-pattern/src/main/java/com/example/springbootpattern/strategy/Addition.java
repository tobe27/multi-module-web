package com.example.springbootpattern.strategy;

/**
 * @author CREATED BY L.C.Y on 2019-3-6
 */
public class Addition implements Strategy {
    /**
     * 计算方法-加法
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
