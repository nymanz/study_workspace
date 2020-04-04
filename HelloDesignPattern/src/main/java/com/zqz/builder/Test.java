package com.zqz.builder;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 23:56
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        AbstractBuilder builder1 = new ConcreteAbstractBuilder1();
        AbstractBuilder builder2 = new ConcreteAbstractBuilder2();

        director.construct(builder1);
        Product result = builder1.getResult();
        result.show();

        director.construct(builder2);
        Product result2 = builder2.getResult();
        result2.show();
    }
}
