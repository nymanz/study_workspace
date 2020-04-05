package com.zqz.mediator;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 00:41
 * @changeRecord
 */
public abstract class Mediator {
    public abstract void send(String message, Colleague colleague);
}
