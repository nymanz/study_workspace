package com.zqz.flyweight;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-06 01:15
 * @changeRecord
 */
public class Test {
    public static void main(String[] args) {
        int extriinsicstate = 22;

        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("x");
        fx.operation(--extriinsicstate);

        Flyweight fx2 = f.getFlyweight("y");
        fx2.operation(--extriinsicstate);

        Flyweight fx3 = f.getFlyweight("z");
        fx3.operation(--extriinsicstate);

        Flyweight uf = new UnshareConcreteFlyweight();
        uf.operation(--extriinsicstate);
    }
}
