package com.zqz.observer.way;

import com.zqz.observer.way.ConcreteObserver;
import com.zqz.observer.way.ConcreteSubject;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 00:33
 * @changeRecord
 */
public class Test {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver(subject, "x"));
        subject.attach(new ConcreteObserver(subject, "y"));
        subject.attach(new ConcreteObserver(subject, "z"));

        subject.setSubjectState("abc");

        subject.Notify();

    }
}
