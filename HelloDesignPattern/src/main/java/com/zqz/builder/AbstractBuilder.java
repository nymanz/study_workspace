package com.zqz.builder;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 23:44
 * @changeRecord
 */
public abstract class AbstractBuilder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult();
}
