package com.zqz.observer.way2;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 09:54
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        ConcreteSubject2 subject = new ConcreteSubject2();
        subject.addObserver(new ConcreteObserver2(subject, "x"));
        subject.addObserver(new ConcreteObserver2(subject, "y"));
        subject.addObserver(new ConcreteObserver2(subject, "z"));

        subject.setSubjectState("abc");

        subject.notifyObservers();
    }
}
