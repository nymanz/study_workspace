package com.zqz.builder;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 23:53
 * @changeRecord
 */
public class ConcreteAbstractBuilder2 extends AbstractBuilder {

    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("builder2 PartA");
    }

    @Override
    public void buildPartB() {
        product.add("builder2 PartB");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
