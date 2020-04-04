package com.zqz.factory;

import java.util.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 21:11
 * @changeRecord
 */
public class Product1 extends AbstractProduct {
    private Logger logger = Logger.getLogger("Product1");
    @Override
    public void writeName() {
        logger.info("these name is Product1");
    }
}
