package com.zqz.state;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 19:27
 * @changeRecord
 */
public class ConcreteState1 implements State {
    @Override
    public void handle(Context context) {
        System.out.println("状态1执行");
        context.setCurrentState(new ConcreteState2());
    }
}
