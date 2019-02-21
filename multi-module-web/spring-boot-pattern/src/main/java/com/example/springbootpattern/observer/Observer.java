package com.example.springbootpattern.observer;

/**
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public abstract class Observer {
    // 信息发布者
    protected SubjectPublisher subjectPublisher;

    // 更新信息
    public abstract void update();
}
