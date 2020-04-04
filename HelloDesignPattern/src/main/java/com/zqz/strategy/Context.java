package com.zqz.strategy;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 20:16
 * @changeRecord
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void doingStrategy(){
        strategy.doing();
    }
}
