package com.example.springbootpattern.observer;

/**
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public interface Observable {
    /**
     * 设置发布信息
     * 同时通知订阅者
     * @param message
     */
    void setMessage(String message);

    /**
     * 绑定订阅者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 通知订阅者
     */
    void notifyAllObservers();
}
