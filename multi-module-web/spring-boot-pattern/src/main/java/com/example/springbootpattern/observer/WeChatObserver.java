package com.example.springbootpattern.observer;

/**
 * @author CREATED BY L.C.Y on 2019-2-21
 */
public class WeChatObserver extends Observer {

    public WeChatObserver(SubjectPublisher subjectPublisher) {
        subjectPublisher.attach(this);
        this.subjectPublisher = subjectPublisher;
    }
    @Override
    public void update() {
        System.out.println("WeChat Subscribe Message:" + subjectPublisher.getMessage());
    }

}
