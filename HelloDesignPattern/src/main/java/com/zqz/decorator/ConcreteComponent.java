package com.zqz.decorator;

import java.util.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @mobile 18716022536
 * @created 2020-04-04 18:10
 * @changeRecord
 */
public class ConcreteComponent extends Component {
    private Logger logger = Logger.getLogger("ConcreteComponent");

    @Override
    public void Operation() {
        logger.info("ConcreteComponent # Operation");
    }
}
