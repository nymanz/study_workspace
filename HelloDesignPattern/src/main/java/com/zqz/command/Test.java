package com.zqz.command;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 23:56
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);

        Command command2 = new ConcreteCommond2(receiver);
        Invoker invoker = new Invoker();

        invoker.setCommand(command);
        invoker.setCommand(command2);
        invoker.executeCommand();
    }
}
