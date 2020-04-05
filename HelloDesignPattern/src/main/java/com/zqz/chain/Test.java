package com.zqz.chain;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 00:30
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

        int[] request = {2,5,14,22,18,3,27,20};

        for (int i : request) {
            handler1.HandleRequest(i);
        }
    }
}
