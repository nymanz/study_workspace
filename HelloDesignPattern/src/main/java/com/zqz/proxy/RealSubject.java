package com.zqz.proxy;

import java.util.logging.Logger;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 20:57
 * @changeRecord
 */
public class RealSubject extends Subject {
    private Logger logger = Logger.getLogger("RealSubject");

    @Override
    public void request() {
        logger.info("真实的请求");
    }
}
