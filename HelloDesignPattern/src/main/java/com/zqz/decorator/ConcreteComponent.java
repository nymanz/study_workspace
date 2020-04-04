package com.zqz.decorator;

import java.util.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @changeRecord
 */
public class ConcreteComponent extends Component {
    private Logger logger = Logger.getLogger("ConcreteComponent");

    @Override
    public void Operation() {
        logger.info("ConcreteComponent # Operation");
    }
}
