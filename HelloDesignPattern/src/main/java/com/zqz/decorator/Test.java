package com.zqz.decorator;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 18:42
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB();


        decoratorA.setComponent(c);
        decoratorB.setComponent(decoratorA);
        decoratorB.Operation();


    }
}
