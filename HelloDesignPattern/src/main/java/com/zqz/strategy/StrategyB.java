package com.zqz.strategy;

import com.sun.istack.internal.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @changeRecord
 */
public class StrategyB extends Strategy {
    private Logger logger = Logger.getLogger(StrategyB.class);

    @Override
    public void doing() {
        logger.info("start do StrategyB");
    }
}
