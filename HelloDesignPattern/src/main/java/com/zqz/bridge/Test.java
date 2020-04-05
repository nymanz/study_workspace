package com.zqz.bridge;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 23:30
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        Abstraction abstraction = new RefineedAbstraction();
        abstraction.setImplementor(new ConcreteImplementorA());
        abstraction.operation();

        abstraction.setImplementor(new ConcreteImplementorB());
        abstraction.operation();
    }
}
