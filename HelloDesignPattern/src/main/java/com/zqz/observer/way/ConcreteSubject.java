package com.zqz.observer.way;

import com.zqz.observer.way.AbstractSubject;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 00:27
 * @changeRecord
 */
public class ConcreteSubject extends AbstractSubject {
    private String subjectState;

    public String getSubjectState(){
        return this.subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
