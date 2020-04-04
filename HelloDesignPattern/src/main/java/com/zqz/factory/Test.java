package com.zqz.factory;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 21:17
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        IFactory factory = new Factory1();
        AbstractProduct product = factory.getProduct();
        product.writeName();

        IFactory factory2 = new Factory2();
        AbstractProduct product2 = factory2.getProduct();
        product2.writeName();
    }
}
