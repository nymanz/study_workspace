package com.zqz.state;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 19:28
 * @changeRecord
 */
public class ConcreteState2 implements State {
    @Override
    public void handle(Context context) {
        System.out.println("状态2执行");
        context.setCurrentState(new ConcreteState1());
    }
}
