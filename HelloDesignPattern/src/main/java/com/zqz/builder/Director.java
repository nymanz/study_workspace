package com.zqz.builder;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 23:54
 * @changeRecord
 */
public class Director {

    public void construct(AbstractBuilder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
