package com.zqz.decorator;

import java.util.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @changeRecord
 */
public class ConcreteDecoratorB extends Decorator {
    private Logger logger = Logger.getLogger("ConcreteDecoratorB");

    @Override
    public void Operation() {
        super.Operation();
        AddedBehavior();
        logger.info("具体装饰对象B的操作");
    }

    private void AddedBehavior(){
        logger.info("ConcreteDecoratorB # AddedBehavior");
    }
}
