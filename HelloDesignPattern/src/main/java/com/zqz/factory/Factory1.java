package com.zqz.factory;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 21:15
 * @changeRecord
 */
public class Factory1 implements IFactory {
    public AbstractProduct getProduct() {
        return new Product1();
    }
}
