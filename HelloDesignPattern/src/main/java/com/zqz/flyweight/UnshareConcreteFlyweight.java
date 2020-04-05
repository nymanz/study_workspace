package com.zqz.flyweight;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 01:09
 * @changeRecord
 */
public class UnshareConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extriinsicstate) {
        System.out.println("不共享的Flywight：" + extriinsicstate);

    }
}
