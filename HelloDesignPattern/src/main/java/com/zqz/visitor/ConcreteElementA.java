package com.zqz.visitor;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
*
 * @created 2020-04-06 02:12
 * @changeRecord
 */
public class ConcreteElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    public void operationA(){

    }
}
