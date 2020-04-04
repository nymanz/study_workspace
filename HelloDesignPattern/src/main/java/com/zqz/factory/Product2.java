package com.zqz.factory;

import java.util.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 21:14
 * @changeRecord
 */
public class Product2 extends AbstractProduct {
    private Logger logger = Logger.getLogger("Product2");
    @Override
    public void writeName() {
        logger.info("these name is Product2");
    }
}
