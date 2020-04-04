package com.zqz.prototype;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 21:35
 * @changeRecord
 */
public class Test {

    public static void main(String[] args) {
        ConcretePrototype1 p1 = new ConcretePrototype1("I");
        ConcretePrototype1 p2 = p1.clonePrototy();
        System.out.println(p2.getId());
    }
}
