package com.zqz.visitor;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
*
 * @created 2020-04-06 02:07
 * @changeRecord
 */
public abstract class Visitor {
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}
