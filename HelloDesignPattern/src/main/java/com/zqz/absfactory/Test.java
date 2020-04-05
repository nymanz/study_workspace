package com.zqz.absfactory;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-05 10:32
 * @changeRecord
 */
public class Test {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1();
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
        System.out.println(productA);
        System.out.println(productB);

        AbstractFactory factory2 = new ConcreteFactory2();
        AbstractProductA productA2 = factory2.createProductA();
        AbstractProductB productB2 = factory2.createProductB();
        System.out.println(productA2);
        System.out.println(productB2);
    }
}
