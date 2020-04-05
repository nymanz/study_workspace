package com.zqz.observer.way2;

import java.util.Observable;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 09:51
 * @changeRecord
 */
public class ConcreteSubject2 extends Observable {
    private String subjectState;

    public String getSubjectState(){
        return this.subjectState;
    }

    public void setSubjectState(String subjectState) {
        setChanged();
        this.subjectState = subjectState;
    }
}
