package com.zqz.interpreter;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 01:35
 * @changeRecord
 */
public class TerminalExpression extends AbstractExpression{

    @Override
    public void interpret(Context context) {
        System.out.println("终端解释器");
    }
}
