package com.zqz.visitor;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
*
 * @created 2020-04-06 02:17
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new ConcreteElementA());
        o.attach(new ConcreteElementB());
        ConcreteVistor1 v1 = new ConcreteVistor1();
        ConcreteVistor2 v2 = new ConcreteVistor2();
        o.accept(v1);
        o.accept(v2);
    }
}
