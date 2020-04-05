package com.zqz.visitor;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
*
 * @created 2020-04-06 02:11
 * @changeRecord
 */
public abstract class Element {
    public abstract void accept(Visitor visitor);
}
