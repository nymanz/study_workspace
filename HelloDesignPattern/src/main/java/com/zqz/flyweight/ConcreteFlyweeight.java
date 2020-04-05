package com.zqz.flyweight;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 01:07
 * @changeRecord
 */
public class ConcreteFlyweeight extends Flyweight {
    @Override
    public void operation(int extriinsicstate) {
        System.out.println("具体Flywight：" + extriinsicstate);
    }
}
