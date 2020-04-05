package com.zqz.state;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 19:25
 * @changeRecord
 */
public class Context {
    private State currentState;

    public Context(){
        currentState = new ConcreteState1();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void request(){
        currentState.handle(this);
    }
}
