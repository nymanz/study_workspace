package com.zqz.visitor;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
*
 * @created 2020-04-06 02:10
 * @changeRecord
 */
public class ConcreteVistor2 extends Visitor{
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA + "被ConcreteVistor2访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB + "被ConcreteVistor2访问");

    }
}
