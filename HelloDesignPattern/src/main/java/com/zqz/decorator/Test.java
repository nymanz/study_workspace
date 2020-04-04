package com.zqz.decorator;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @mobile 18716022536
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
