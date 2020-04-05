package com.zqz.iterator;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-05 22:12
 * @changeRecord
 */
public abstract class Iterator{
    public abstract Object first();
    public abstract Object next();
    public abstract Object currentItem();
    public abstract boolean isDone();
}
