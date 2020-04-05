package com.zqz.command;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 00:08
 * @changeRecord
 */
public class ConcreteCommond2 extends Command {
    public ConcreteCommond2(Receiver receiver){
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action2();
    }
}
