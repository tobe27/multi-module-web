package com.example.springbootpattern.observer;

/**
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public class DingDingObserver extends Observer {

    public DingDingObserver(SubjectPublisher subjectPublisher) {
        subjectPublisher.attach(this);
        this.subjectPublisher = subjectPublisher;
    }
    @Override
    public void update() {
        System.out.println("DingDing Subscribe Message:" + subjectPublisher.getMessage());
    }
}
