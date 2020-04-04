package com.zqz.strategy;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 20:25
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        StrategyA strategyA = new StrategyA();
        Context context = new Context(strategyA);
        context.doingStrategy();
    }
}
