package com.zqz.decorator;

import java.util.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @mobile 18716022536
 * @created 2020-04-04 18:16
 * @changeRecord
 */
public class ConcreteDecoratorA extends Decorator {
    private Logger logger = Logger.getLogger("ConcreteDecoratorA");


    private String addedState;

    @Override
    public void Operation() {
        super.Operation();
        addedState = "New State";
        logger.info("具体装饰对象A的操作");
    }
}
