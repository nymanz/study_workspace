package com.zqz.observer.way;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 00:20
 * @changeRecord
 */
public class AbstractSubject {
    private List<AbstractObserver> observers = new ArrayList<>();

    public void attach(AbstractObserver observer){
        observers.add(observer);
    }

    public void detach(AbstractObserver observer){
        observers.remove(observer);
    }

    public void Notify(){
        for (AbstractObserver observer : observers) {
            observer.update();
        }
    }
}
