package com.zqz.strategy;

import com.sun.istack.internal.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 20:21
 * @changeRecord
 */
public class StrategyA extends Strategy {
    private Logger logger = Logger.getLogger(StrategyA.class);

    @Override
    public void doing() {
        logger.info("start do strategyA");
    }
}
