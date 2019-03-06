package com.example.springbootpattern.iterator;

/**
 * @author CREATED BY L.C.Y on 2019-3-6
 */
public interface Iterator {
    /**
     * 是否有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 下一个元素
     * @return
     */
    Object next();
}
