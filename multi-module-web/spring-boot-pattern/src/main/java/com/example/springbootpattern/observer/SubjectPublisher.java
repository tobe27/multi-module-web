package com.example.springbootpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为型模式-观察者模式
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知它的依赖对象。
 *      一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。
 *      其实就是发布订阅模式，发布者发布信息，订阅者获取信息，订阅了就能收到信息，没订阅就收不到信息
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public class SubjectPublisher implements Observable {

    // 订阅者
    private List<Observer> observers = new ArrayList<>();
    // 发布的信息
    private String message;

    public String getMessage() {
        return message;
    }

    /**
     * 设置发布信息
     * 同时通知订阅者
     *
     * @param message
     */
    @Override
    public void setMessage(String message) {
        this.message = message;

        // 通知所有订阅者发布了消息
        notifyAllObservers();
    }

    /**
     * 绑定订阅者
     *
     * @param observer
     */
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 通知订阅者更新信息
     */
    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public static void main(String[] args) {
        SubjectPublisher subjectPublisher = new SubjectPublisher();

        // 订阅subjectPublisher
        new DingDingObserver(subjectPublisher);
        new WeChatObserver(subjectPublisher);
        new QQObserve(subjectPublisher);

        // 发布消息
        subjectPublisher.setMessage("First Message");

        subjectPublisher.setMessage("Second Message");
    }
}
