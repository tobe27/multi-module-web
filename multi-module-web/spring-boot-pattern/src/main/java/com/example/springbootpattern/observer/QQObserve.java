package com.example.springbootpattern.observer;

/**
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public class QQObserve extends Observer {
    public QQObserve(SubjectPublisher subjectPublisher) {
        subjectPublisher.attach(this);
        this.subjectPublisher = subjectPublisher;
    }
    @Override
    public void update() {
        System.out.println("QQ Subscribe Message:" + subjectPublisher.getMessage());
    }
}
