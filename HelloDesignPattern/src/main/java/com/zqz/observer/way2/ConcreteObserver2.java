package com.zqz.observer.way2;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 09:45
 * @changeRecord
 */
public class ConcreteObserver2 implements Observer {


    private String name;
    private String observerState;
    private ConcreteSubject2 subject;

    public ConcreteObserver2(ConcreteSubject2 subject, String name){
        this.subject = subject;
        this.name = name;
    }

    public ConcreteSubject2 getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject2 subject) {
        this.subject = subject;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ConcreteSubject2){
            observerState = subject.getSubjectState();
            System.out.println("观察者" + name + "的新状态是" + observerState);
        }
    }
}
